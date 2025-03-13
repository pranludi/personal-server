package io.pranludi.server.member.service;

import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

  @Autowired
  MemberService memberService;

  @Transactional
  public Member login(String memberId, LocalDateTime currentTime) {
    Optional<Member> optMember = memberService.getMember(memberId);
    if (optMember.isEmpty()) {
      memberService.save(memberId, initialMember(memberId, currentTime));
    }

    return memberService.findMember(memberId);
  }

  private static Member initialMember(String memberId, LocalDateTime now) {
    List<Currency> currencies = new ArrayList<>();
    currencies.add(new Currency(101, 1000, 0, now, now));
    currencies.add(new Currency(102, 2, 0, now, now));
    List<Item> items = new ArrayList<>();
    items.add(new Item(201, 1, 0, now, now));
    items.add(new Item(202, 2, 0, now, now));
    return new Member(0, "NickName:" + memberId, now, currencies, items);
  }

}
