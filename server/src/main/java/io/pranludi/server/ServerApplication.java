package io.pranludi.server;

import java.util.TimeZone;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) {

    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    new SpringApplicationBuilder(ServerApplication.class)
      .run(args);

  }

}
