package io.pranludi.server;

import java.util.TimeZone;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) {

    String port = "12009";
    String srvVer = "0.0.0";
    String srvConf = "sandbox"; // CommonUtil.srvConf;

    String appName = String.format("Server %s %s", srvConf, srvVer);

    System.setProperty("server.port", port);
    System.setProperty("spring.profiles.active", srvConf);
    System.setProperty("spring.application.name", appName);
    System.setProperty("user.timezone", "GMT+09:00");

    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    // startup log disable
    new SpringApplicationBuilder(ServerApplication.class)
      .logStartupInfo(false) // true or false
      .bannerMode(Mode.LOG) // Mode.OFF, Mode.CONSOLE, Mode.LOG
      .run(args);

  }

  @Bean
  public TaskScheduler taskScheduler() {
    return new ConcurrentTaskScheduler();
  }

}
