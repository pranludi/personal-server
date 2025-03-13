package io.pranludi.server.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class GracefulShutdownEventListener implements ApplicationListener<ContextClosedEvent> {

  @Autowired
  private GracefulShutdownHandlerWrapper gracefulShutdownHandlerWrapper;

  @Override
  public void onApplicationEvent(ContextClosedEvent event) {

    gracefulShutdownHandlerWrapper.getGracefulShutdownHandler().shutdown();

    try {
      gracefulShutdownHandlerWrapper.getGracefulShutdownHandler().awaitShutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
