package io.pranludi.server.entity;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.MemberName;
import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.MemberStatus;
import io.pranludi.server.domain.member.Reward;
import io.pranludi.server.domain.member.RewardCurrency;
import io.pranludi.server.domain.member.RewardItem;
import io.pranludi.server.domain.member.RewardProfile;
import io.pranludi.server.protobuf.service.CurrenciesDTO;
import io.pranludi.server.protobuf.service.CurrencyDTO;
import io.pranludi.server.protobuf.service.ItemDTO;
import io.pranludi.server.protobuf.service.ItemsDTO;
import io.pranludi.server.protobuf.service.MemberNameDTO;
import io.pranludi.server.protobuf.service.MemberStateDTO;
import io.pranludi.server.protobuf.service.MemberStatusDTO;
import io.pranludi.server.protobuf.service.RewardDTO;
import io.pranludi.server.protobuf.service.RewardElementDTO;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

// Entity -> Protobuf

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ServiceMapper {

  ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

  ZoneOffset DEFAULT_ZONE = ZoneOffset.of("+9");

  default Long localDateTimeToLong(LocalDateTime localDateTime) {
    return localDateTime.toInstant(DEFAULT_ZONE).toEpochMilli();
  }

  MemberStatusDTO entityToProto(MemberStatus entity);

  // ---

  MemberNameDTO entityToProto(MemberName entity);

  CurrencyDTO entityToProto(Currency entity);

  ItemDTO entityToProto(Item entity);

  default CurrenciesDTO currencyMap(Map<ItemDataId, Currency> value) {
    CurrenciesDTO.Builder builder = CurrenciesDTO.newBuilder();
    for (Currency currency : value.values()) {
      builder.addCurrencies(entityToProto(currency));
    }
    return builder.build();
  }

  default ItemsDTO itemMap(Map<ItemDataId, Item> value) {
    ItemsDTO.Builder builder = ItemsDTO.newBuilder();
    for (Item item : value.values()) {
      builder.addItems(entityToProto(item));
    }
    return builder.build();
  }

  MemberStateDTO entityToProto(Member entity);

  RewardElementDTO.Currency entityToProto(RewardCurrency entity);

  RewardElementDTO.Item entityToProto(RewardItem entity);

  RewardElementDTO.Profile entityToProto(RewardProfile entity);

  default RewardDTO rewardEntityToProto(Reward entity) {
    if (entity.reward().currency().dataId() != 0) {
      return RewardDTO.newBuilder()
        .setReward(RewardElementDTO.newBuilder().setCurrency(entityToProto(entity.reward().currency())).build()).build();
    } else if (entity.reward().item().dataId() != 0) {
      return RewardDTO.newBuilder()
        .setReward(RewardElementDTO.newBuilder().setItem(entityToProto(entity.reward().item())).build()).build();
    } else if (entity.reward().profile().dataId() != 0) {
      return RewardDTO.newBuilder()
        .setReward(RewardElementDTO.newBuilder().setProfile(entityToProto(entity.reward().profile())).build()).build();
    } else {
      throw new IllegalArgumentException("Unknown reward type");
    }
  }

}
