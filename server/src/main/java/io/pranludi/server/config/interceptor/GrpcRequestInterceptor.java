package io.pranludi.server.config.interceptor;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.pranludi.server.domain.member.MemberId;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class GrpcRequestInterceptor implements ServerInterceptor {

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
    String memberId = metadata.get(InterceptorConstant.MD_MEMBER_ID);
    Context context = Context.current().withValue(InterceptorConstant.CTX_MEMBER_ID, new MemberId(memberId));
    return Contexts.interceptCall(context, serverCall, metadata, serverCallHandler);
  }

}
