package io.pranludi.server.member;

import static org.assertj.core.api.Assertions.assertThat;

import io.pranludi.server.config.TestMetadata;
import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.entity.MemberId;
import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.domain.metadata.Metadata;
import io.pranludi.server.entity.ServerMapper;
import io.pranludi.server.logic.MemberLogic;
import io.pranludi.server.protobuf.server.CurrencyDTO;
import io.pranludi.server.protobuf.server.MemberStateDTO;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class MemberTest {

  @Test
  void newMember() {

    LocalDateTime now = LocalDateTime.now();
    Metadata metadata = TestMetadata.setMetadata();
    EnvironmentData env = new EnvironmentData(new MemberId("test1"), now, metadata);
    Member member = MemberLogic.initialMember().apply(env);
    assertThat(member.createdAt()).isEqualTo(now);
  }

  @Test
  void memberMapStruct() {

    ServerMapper serverMapper = ServerMapper.INSTANCE;
    LocalDateTime now = LocalDateTime.now();
    long nowMillis = serverMapper.localDateTimeToLong(now);

    Metadata metadata = TestMetadata.setMetadata();
    EnvironmentData env = new EnvironmentData(new MemberId("test1"), now, metadata);
    Member member = MemberLogic.initialMember().apply(env);
    assertThat(member.createdAt()).isEqualTo(now);

    ItemDataId itemDataId = new ItemDataId(101);
    Currency currency = member.currencies().get(itemDataId);

    // entity -> protobuf
    MemberStateDTO memberStateDTO = serverMapper.entityToProto(member);
    for (CurrencyDTO dto : memberStateDTO.getCurrencies().getCurrenciesList()) {
      if (dto.getDataId() == itemDataId.value()) {
        assertThat(nowMillis).isEqualTo(dto.getUseAt());
        assertThat(currency.paid()).isEqualTo(dto.getPaid());
        assertThat(currency.free()).isEqualTo(dto.getFree());
      }
    }

    // protobuf -> entity
    Member memberEntity = serverMapper.protoToEntity(memberStateDTO);
    Currency currencyEntity = memberEntity.currencies().get(itemDataId);
    assertThat(nowMillis).isEqualTo(serverMapper.localDateTimeToLong(currencyEntity.useAt()));
    assertThat(currency.paid()).isEqualTo(currencyEntity.paid());
    assertThat(currency.free()).isEqualTo(currencyEntity.free());

  }

}
