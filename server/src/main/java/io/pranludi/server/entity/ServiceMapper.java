package io.pranludi.server.entity;

import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.MemberName;
import io.pranludi.server.domain.member.MemberStatus;
import io.pranludi.server.protobuf.service.CurrencyDTO;
import io.pranludi.server.protobuf.service.ItemDTO;
import io.pranludi.server.protobuf.service.MemberNameDTO;
import io.pranludi.server.protobuf.service.MemberStateDTO;
import io.pranludi.server.protobuf.service.MemberStatusDTO;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ServiceMapper {

  ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

  ZoneOffset DEFAULT_ZONE = ZoneOffset.of("+9");

  default Long localDateTimeToLong(LocalDateTime localDateTime) {
    return localDateTime.toInstant(DEFAULT_ZONE).toEpochMilli();
  }

  default LocalDateTime longToLocalDateTime(long millis) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), DEFAULT_ZONE);
  }

  @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
  MemberStatus protoToEntity(MemberStatusDTO proto);

  MemberStatusDTO entityToProto(MemberStatus entity);

  // ---

  MemberName protoToEntity(MemberNameDTO proto);

  MemberNameDTO entityToProto(MemberName entity);

  Currency protoToEntity(CurrencyDTO proto);

  CurrencyDTO entityToProto(Currency entity);

  Item protoToEntity(ItemDTO proto);

  ItemDTO entityToProto(Item entity);

  @Mapping(source = "itemsList", target = "items")
  @Mapping(source = "currenciesList", target = "currencies")
  Member protoToEntity(MemberStateDTO proto);

  @Mapping(source = "items", target = "itemsList")
  @Mapping(source = "currencies", target = "currenciesList")
  MemberStateDTO entityToProto(Member entity);

}
