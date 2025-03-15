package io.pranludi.server.cheat;

import io.grpc.stub.StreamObserver;
import io.pranludi.server.config.interceptor.GrpcRequestInterceptor;
import io.pranludi.server.config.interceptor.GrpcResponseInterceptor;
import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.member.Reward;
import io.pranludi.server.entity.ServiceMapper;
import io.pranludi.server.protobuf.service.Cheat.CheatRewardRequest;
import io.pranludi.server.protobuf.service.Cheat.CheatRewardResponse;
import io.pranludi.server.protobuf.service.CheatServiceGrpc.CheatServiceImplBase;
import io.pranludi.server.protobuf.service.RewardDTO;
import io.pranludi.server.util.MakeEnvironment;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService(interceptors = {GrpcRequestInterceptor.class, GrpcResponseInterceptor.class})
public class CheatGrpcService extends CheatServiceImplBase {

  final CheatService cheatService;
  final MakeEnvironment makeEnvironment;

  public CheatGrpcService(MakeEnvironment makeEnvironment, CheatService cheatService) {
    this.makeEnvironment = makeEnvironment;
    this.cheatService = cheatService;
  }

  @Override
  public void cheatReward(CheatRewardRequest req, StreamObserver<CheatRewardResponse> responseObserver) {
    Reward reward = cheatService
      .cheatReward(new ItemDataId(req.getItemDataId()), req.getAmount())
      .apply(makeEnvironment.make());

    RewardDTO rewardDTO = ServiceMapper.INSTANCE.rewardEntityToProto(reward);
    System.out.println("reward = " + reward);
    System.out.println("rewardDTO = " + rewardDTO);

    CheatRewardResponse res = CheatRewardResponse.newBuilder()
      .addRewards(rewardDTO)
      .build();
    responseObserver.onNext(res);
    responseObserver.onCompleted();
  }

}
