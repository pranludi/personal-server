package io.pranludi.server.config.interceptor;

import io.grpc.Context;
import io.grpc.Metadata;
import io.pranludi.server.domain.member.MemberId;

public class InterceptorConstant {

  public static final Metadata.Key<String> MD_MEMBER_ID = Metadata.Key.of("member-id", Metadata.ASCII_STRING_MARSHALLER);
  public static final Context.Key<MemberId> CTX_MEMBER_ID = Context.key("member-id");

}
