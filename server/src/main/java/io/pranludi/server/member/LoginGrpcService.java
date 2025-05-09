package io.pranludi.server.member;

import io.grpc.stub.StreamObserver;
import io.pranludi.server.config.interceptor.GrpcRequestInterceptor;
import io.pranludi.server.config.interceptor.GrpcResponseInterceptor;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.entity.MemberName;
import io.pranludi.server.entity.ServiceMapper;
import io.pranludi.server.protobuf.service.Member.ChangeNameRequest;
import io.pranludi.server.protobuf.service.Member.ChangeNameResponse;
import io.pranludi.server.protobuf.service.Member.LoginRequest;
import io.pranludi.server.protobuf.service.Member.LoginResponse;
import io.pranludi.server.protobuf.service.MemberServiceGrpc.MemberServiceImplBase;
import io.pranludi.server.util.MakeEnvironment;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService(interceptors = {GrpcRequestInterceptor.class, GrpcResponseInterceptor.class})
public class LoginGrpcService extends MemberServiceImplBase {

  final LoginService loginService;
  final MakeEnvironment makeEnvironment;

  public LoginGrpcService(MakeEnvironment makeEnvironment, LoginService loginService) {
    this.makeEnvironment = makeEnvironment;
    this.loginService = loginService;
  }

  @Override
  public void login(LoginRequest req, StreamObserver<LoginResponse> responseObserver) {
    Member memberDoc = loginService.login()
      .apply(makeEnvironment.make());

    LoginResponse res = LoginResponse.newBuilder()
      .setMemberState(ServiceMapper.INSTANCE.entityToProto(memberDoc))
      .build();
    responseObserver.onNext(res);
    responseObserver.onCompleted();
  }

  @Override
  public void changeName(ChangeNameRequest req, StreamObserver<ChangeNameResponse> responseObserver) {
    MemberName memberName = loginService
      .changeMemberName(req.getName())
        .apply(makeEnvironment.make());

    System.out.println("LoginGrpcService.changeName");

    ChangeNameResponse res = ChangeNameResponse.newBuilder()
      .setMemberName(ServiceMapper.INSTANCE.entityToProto(memberName))
      .build();
    responseObserver.onNext(res);
    responseObserver.onCompleted();
  }
}
