package io.pranludi.server.member.controller;

import io.grpc.stub.StreamObserver;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.exception.CommonException;
import io.pranludi.server.member.entity.UserServiceMapper;
import io.pranludi.server.member.service.LoginService;
import io.pranludi.server.metadata.service.MetadataService;
import io.pranludi.server.protobuf.service.Member.LoginRequest;
import io.pranludi.server.protobuf.service.Member.LoginResponse;
import io.pranludi.server.protobuf.service.MemberServiceGrpc.MemberServiceImplBase;
import io.pranludi.server.protobuf.service.MemberStateDTO;
import java.time.LocalDateTime;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class LoginGrpcController extends MemberServiceImplBase {

  final MetadataService metadataService;
  final LoginService loginService;

  public LoginGrpcController(MetadataService metadataService, LoginService loginService) {
    this.metadataService = metadataService;
    this.loginService = loginService;
  }


  @Override
  public void login(LoginRequest req, StreamObserver<LoginResponse> responseObserver) {

    try {
      String memberId = req.getMemberId();
      LocalDateTime currentTime = metadataService.currentDataTime();
      Member memberDoc = loginService.login(memberId, currentTime);
      MemberStateDTO memberState = UserServiceMapper.INSTANCE.entityToProto(memberDoc);

      LoginResponse res = LoginResponse.newBuilder().setMemberState(memberState).build();
      responseObserver.onNext(res);
      responseObserver.onCompleted();
    } catch (Exception e) {
      throw new CommonException("Exception");
    }

  }
}
