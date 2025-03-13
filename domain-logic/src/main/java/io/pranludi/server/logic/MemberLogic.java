package io.pranludi.server.logic;

import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.MemberName;
import io.pranludi.server.domain.member.MemberStatus;
import io.pranludi.server.domain.metadata.EnvironmentData;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MemberLogic {

  public static Function<EnvironmentData, Member> initialMember() {
    return (EnvironmentData env) -> {
      LocalDateTime now = env.currentDateTime();
      List<Currency> currencies = new ArrayList<>();
      currencies.add(new Currency(101, 1000, 0, now, now));
      currencies.add(new Currency(102, 2, 0, now, now));
      List<Item> items = new ArrayList<>();
      items.add(new Item(201, 1, 0, now, now));
      items.add(new Item(202, 2, 0, now, now));
      MemberName memberName = new MemberName("NickName:" + env.memberId(), 0);
      return new Member(env.metadata().currentMemberVersion(), MemberStatus.NORMAL, memberName, now, now, currencies, items);
    };
  }

}
