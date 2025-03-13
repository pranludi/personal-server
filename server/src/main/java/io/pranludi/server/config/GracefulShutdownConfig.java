package io.pranludi.server.config;

import io.pranludi.server.component.GracefulShutdownHandlerWrapper;
import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GracefulShutdownConfig {

  @Autowired
  private GracefulShutdownHandlerWrapper gracefulShutdownHandlerWrapper;

  static class MyUndertowBuilderCustomizer implements UndertowBuilderCustomizer {

    @Override
    public void customize(Undertow.Builder builder) {
      // IDLE_TIMEOUT: The idle timeout in milliseconds after which the channel will be closed.
      builder.setServerOption(UndertowOptions.IDLE_TIMEOUT, 1000 * 10);
      builder.setServerOption(UndertowOptions.REQUEST_PARSE_TIMEOUT, 1000 * 10);
      builder.setServerOption(UndertowOptions.NO_REQUEST_TIMEOUT, 1000 * 10);
    }
  }

  @Bean
  public UndertowServletWebServerFactory servletWebServerFactory() {

    UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
    factory.addDeploymentInfoCustomizers(deploymentInfo -> deploymentInfo.addOuterHandlerChainWrapper(gracefulShutdownHandlerWrapper));
    factory.addBuilderCustomizers(new MyUndertowBuilderCustomizer());

    return factory;
  }

}
