package io.pranludi.server.member.controller;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.exception.CommonException;
import io.pranludi.server.member.service.LoginService;
import io.pranludi.server.metadata.service.MetadataService;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/web")
public class LoginController {

  @Autowired
  MetadataService metadataService;
  @Autowired
  LoginService loginService;

  // {get} /login?json= 사용자 로그인
  @GetMapping(value = "/login")
  public Mono<String> login(HttpServletRequest req
    , @RequestParam(value = "memberId") String memberId
  ) {

    try {
      LocalDateTime currentTime = metadataService.currentDataTime();
      Member memberDoc = loginService.login(memberId, currentTime);
      return Mono.just(memberDoc.toString());
    } catch (Exception e) {
      throw new CommonException("Exception");
    }

  }

}
