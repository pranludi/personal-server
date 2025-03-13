package io.pranludi.server.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class StartupPreparations implements InitializingBean {

  @Override
  public void afterPropertiesSet() {
    System.out.println("Server Start - data loading");
  }

}
