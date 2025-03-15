package io.pranludi.server.logic;

import io.pranludi.server.domain.entity.ItemDataId;
import io.pranludi.server.domain.member.Currency;
import io.pranludi.server.domain.member.Item;
import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.member.Reward;
import io.pranludi.server.domain.member.RewardCurrency;
import io.pranludi.server.domain.member.RewardElement;
import io.pranludi.server.domain.member.RewardItem;
import io.pranludi.server.domain.member.RewardProfile;
import io.pranludi.server.domain.metadata.EnvironmentData;
import io.pranludi.server.domain.metadata.ItemInfo;
import io.pranludi.server.exception.ValidationError;
import java.util.function.Function;

public class RewardLogic {

  public static Function<EnvironmentData, Reward> receive(Member member, boolean isPaid, ItemDataId dataId, long amount) {
    return (EnvironmentData env) -> {
      ItemInfo itemInfo = MetadataLogic.inquireItemInfo(dataId).apply(env.metadata());
      switch (itemInfo.itemType()) {
        case Currency1, Currency2 -> {
          for (Currency currency : member.currencies().values()) {
            if (currency.dataId() == dataId.value()) {
              if (isPaid) {
                member.currencies().put(dataId, currency.withPaid(currency.paid() + amount));
              } else {
                member.currencies().put(dataId, currency.withFree(currency.free() + amount));
              }
            }
          }
          return new Reward(new RewardElement(new RewardCurrency(dataId.value(), isPaid ? amount : 0, isPaid ? 0 : amount), RewardItem.empty(), RewardProfile.empty()));
        }
        case Item1, Item2 -> {
          for (Item item : member.items().values()) {
            if (item.dataId() == dataId.value()) {
              if (isPaid) {
                member.items().put(dataId, item.withPaid(item.paid() + amount));
              } else {
                member.items().put(dataId, item.withFree(item.free() + amount));
              }
            }
          }
          return new Reward(new RewardElement(RewardCurrency.empty(), new RewardItem(dataId.value(), amount), RewardProfile.empty()));
        }
      }
      throw new ValidationError("Invalid item type: " + itemInfo);
    };
  }
}
