package io.pranludi.server.entity;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.MemberName;
import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.MemberStatus;
import io.pranludi.server.protobuf.server.CurrenciesDTO;
import io.pranludi.server.protobuf.server.CurrencyDTO;
import io.pranludi.server.protobuf.server.ItemDTO;
import io.pranludi.server.protobuf.server.ItemsDTO;
import io.pranludi.server.protobuf.server.MemberNameDTO;
import io.pranludi.server.protobuf.server.MemberStateDTO;
import io.pranludi.server.protobuf.server.MemberStatusDTO;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

// Entity -> Protobuf(DB)
// Protobuf(DB) -> Entity

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ServerMapper {

  ServerMapper INSTANCE = Mappers.getMapper(ServerMapper.class);

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

  default Map<ItemDataId, Currency> currencyMap(CurrenciesDTO value) {
    Map<ItemDataId, Currency> map = new HashMap<>();
    for (CurrencyDTO dto : value.getCurrenciesList()) {
      Currency currency = protoToEntity(dto);
      map.put(new ItemDataId(currency.dataId()), currency);
    }
    return map;
  }

  default CurrenciesDTO currencyMap(Map<ItemDataId, Currency> value) {
    CurrenciesDTO.Builder builder = CurrenciesDTO.newBuilder();
    for (Currency currency : value.values()) {
      builder.addCurrencies(entityToProto(currency));
    }
    return builder.build();
  }

  default Map<ItemDataId, Item> itemMap(ItemsDTO value) {
    Map<ItemDataId, Item> map = new HashMap<>();
    for (ItemDTO dto : value.getItemsList()) {
      Item item = protoToEntity(dto);
      map.put(new ItemDataId(item.dataId()), item);
    }
    return map;
  }

  default ItemsDTO itemMap(Map<ItemDataId, Item> value) {
    ItemsDTO.Builder builder = ItemsDTO.newBuilder();
    for (Item item : value.values()) {
      builder.addItems(entityToProto(item));
    }
    return builder.build();
  }

  Member protoToEntity(MemberStateDTO proto);

  MemberStateDTO entityToProto(Member entity);

}
