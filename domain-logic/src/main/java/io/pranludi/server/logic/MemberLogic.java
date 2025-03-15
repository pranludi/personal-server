package io.pranludi.server.logic;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.entity.MemberName;
import io.pranludi.server.domain.member.MemberStatus;
import io.pranludi.server.domain.metadata.EnvironmentData;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MemberLogic {

  public static Function<EnvironmentData, Member> initialMember() {
    return (EnvironmentData env) -> {
      LocalDateTime now = env.currentDateTime();

      Map<ItemDataId, Currency> currencies = new HashMap<>();
      currencies.put(new ItemDataId(101), new Currency(101, 1000, 0, now, now));
      currencies.put(new ItemDataId(102), new Currency(102, 2, 0, now, now));

      Map<ItemDataId, Item> items = new HashMap<>();
      items.put(new ItemDataId(201), new Item(201, 1, 0, now, now));
      items.put(new ItemDataId(202), new Item(202, 2, 0, now, now));

      MemberName memberName = new MemberName("NickName:" + env.memberId(), 0);

      return new Member(env.metadata().currentMemberVersion(), MemberStatus.NORMAL, memberName, now, now, currencies, items);
    };
  }

}
