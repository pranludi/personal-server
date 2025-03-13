package io.pranludi.server.domain.member;

import org.apache.commons.lang3.StringUtils;

public enum ItemCode {
  PAID_CRYSTAL(1000001, "Paid Crystal", "Crystal"),
  FREE_CRYSTAL(1000002, "Free Crystal", "Crystal"),
  PAID_HEART(1000003, "Paid Heart", "Heart"),
  FREE_HEART(1000004, "Free Heart", "Heart"),
  // HEART_BOX(1000093, "Heart Box", "HeartBox"), // heart box 에서 받은 하트를 받도록 하기 위해서 서버에서만 사용하는 코드
  PAID_COIN(1000005, "Paid Coin", "Coin"),
  FREE_COIN(1000006, "Free Coin", "Coin"),
  FREE_MEDAL(1009001, "Free Medal", "Medal"),
  PAID_MEDAL(1009002, "Paid Medal", "Medal"),
  //COOKIE_TICKET(1000007, "Cookie Episode Ticket", "Ticket"),
  PAID_PET_GACHA(1000008, "Paid Pet Gacha", "PetGacha"),
  FREE_PET_GACHA(1000009, "Free Pet Gacha", "PetGacha"),
  PAID_PET_SELECT_GACHA(1000010, "Paid Pet Select Gacha", "PetSelectGacha"),
  FREE_PET_SELECT_GACHA(1000011, "Free Pet Select Gacha", "PetSelectGacha"),
  FREE_COMMON_GROW(10100001, "Free Common Grow", "CommonGrow"),
  PAID_COMMON_GROW(10100002, "Paid Common Grow", "CommonGrow"),
  FREE_COMMON_SPECIAL_GROW(10100003, "Free Common Special Grow", "CommonSpecialGrow"),
  PAID_COMMON_SPECIAL_GROW(10100004, "Paid Common Special Grow", "CommonSpecialGrow"),
  PAID_HIDDEN_TICKET(1000012, "Hidden Stage Paid Ticket", "Ticket"),
  FREE_HIDDEN_TICKET(1000013, "Hidden Stage Free Ticket", "Ticket"),
  PAID_SURF_TICKET(1000015, "Surf Paid Ticket", "Event"),
  FREE_SURF_TICKET(1000014, "Surf Stage Free Ticket", "Event"),

  PAID_BATTLE_STAMINA(1000016, "Battle Mode Stamina (유료)", "BattleMode"),
  FREE_BATTLE_STAMINA(1000017, "Battle Mode Stamina (무료)", "BattleMode"),

  ROCKET_VERTICAL(1001001, "세로 로켓", "PreItem"), //
  ROCKET_HORIZONTAL(1001002, "가로 로켓", "PreItem"), //
  BOMB(1001003, "폭탄", "PreItem"), //
  CAULDRON(1001004, "가마솥", "PreItem"),
  ROCKET_RANDOM(1001010, "세로/가로 랜덤 로켓", "PreItem"), // ( 블러싱 콤보에서 사용 )

  INGAME_FREE_HAMMER(1002001, "망치", "InItem"),
  INGAME_FREE_CANDYBOMB(1002002, "십자폭탄", "InItem"),
  INGAME_FREE_CATFOOT(1002003, "셔플", "InItem"),
  INGAME_PAID_HAMMER(1002011, "[유료]망치", "InItem"),
  INGAME_PAID_CANDYBOMB(1002012, "[유료]십자폭탄", "InItem"),
  INGAME_PAID_CATFOOT(1002013, "[유료]셔플", "InItem"),

  PET_MOVE_ONE(1003001, "pet passive 스킬 - 턴 증가", "x"),

  COOKIE_BOOSTER(1004001, "로켓 부스터", "x"),
  //
  HEART_TIME(1005001, "시간제 하트", "Heart"),

  PREITEM_FREE_MOVE(1006001, "[준비-무료] 무브+3", "PreItem"),
  PREITEM_FREE_MIX1(1006002, "[준비-무료] 랜덤 로켓 + 폭탄", "PreItem"),
  PREITEM_FREE_CAULDRON(1006003, "[준비-무료] 무지개 솥", "PreItem"),
  PREITEM_FREE_SCORE(1006004, "[준비-무료] 기본 젤리 점수 10% 증가 아이템", "PreItem"),
  PREITEM_FREE_CE_2(1006005, "[준비-무료] 폭죽 로켓 2개", "PreItem"),
  PREITEM_FREE_CE_3(1006006, "[준비-무료] 코뿔벌 다트 + 무지개 솥", "PreItem"),
  PREITEM_FREE_CE_4(1006007, "[준비-무료] 무지개 곰젤리", "PreItem"),
  PREITEM_FREE_BATTLE_CH(1006008, "[준비-무료] 배틀 모드 - 쿠키 체력 추가", "PreItem"),
  PREITEM_FREE_BATTLE_SG(1006009, "[준비-무료] 배틀 모드 - 스킬 게이지 감소", "PreItem"),

  PREITEM_PAID_MOVE(1006011, "[준비-유료] 무브+3", "PreItem"),
  PREITEM_PAID_MIX1(1006012, "[준비-유료] 랜덤 로켓 + 폭탄", "PreItem"),
  PREITEM_PAID_CAULDRON(1006013, "[준비-유료] 무지개 솥", "PreItem"),
  PREITEM_PAID_SCORE(1006014, "[준비-유료] 기본 젤리 점수 10% 증가 아이템", "PreItem"),
  PREITEM_PAID_CE_2(1006015, "[준비-유료] 폭죽 로켓 2개", "PreItem"),
  PREITEM_PAID_CE_3(1006016, "[준비-유료] 코뿔벌 다트 + 무지개 솥", "PreItem"),
  PREITEM_PAID_CE_4(1006017, "[준비-유료] 무지개 곰젤리", "PreItem"),
  PREITEM_PAID_BATTLE_CH(1006018, "[준비-유료] 배틀 모드 - 쿠키 체력 추가", "PreItem"),
  PREITEM_PAID_BATTLE_SG(1006019, "[준비-유료] 배틀 모드 - 스킬 게이지 감소", "PreItem"),

  PREITEM_TIME_MOVE(1007001, "[준비-시간] 무브+3", "PreItem"),
  PREITEM_TIME_MIX1(1007002, "[준비-시간] 랜덤 로켓 + 폭탄", "PreItem"),
  PREITEM_TIME_CAULDRON(1007003, "[준비-시간] 무지개 솥", "PreItem"),
  PREITEM_TIME_SCORE(1007004, "[준비-시간] 기본 젤리 점수 10% 증가 아이템", "PreItem"),
  PREITEM_TIME_CE_2(1007005, "[준비-시간] 폭죽 로켓 2개", "PreItem"),
  PREITEM_TIME_CE_3(1007006, "[준비-시간] 코뿔벌 다트 + 무지개 솥", "PreItem"),
  PREITEM_TIME_CE_4(1007007, "[준비-시간] 무지개 곰젤리", "PreItem"),
  PREITEM_TIME_BATTLE_CH(1007008, "[준비-시간] 배틀 모드 - 쿠키 체력 추가", "PreItem"),
  PREITEM_TIME_BATTLE_SG(1007009, "[준비-시간] 배틀 모드 - 스킬 게이지 감소", "PreItem"),

  SPECIAL_RESET(1008002, "[광고_스페셜 리셋 방어] 리셋 방어권 id", "specialReset"),
  BATTLE_EXP(1008003, "[배틀] 경험치", "battle"),
  BATTLE_TRAINING_BONUS(1008004, "[배틀] 추가 훈련 횟수", "training"),
  BATTLE_MYSTERY_BOX(1008005, "[배틀] Mystery Box", "Battle"),
  BATTLE_REINFORCE_JELLY(1008006, "[배틀] 강화 아이템 - 젤리 공격력 증가", "Battle"),
  BATTLE_BUFF_REFRESH(1008007, "[배틀] 랜덤 버프 리플레시", "Battle"),

  SEASON_PASS_OBJECT(1009003, "시즌 패스 조각", "seasonpass")
  ;

  private int code;
  private String name;
  private String type;

  ItemCode(int enumValue, String name, String type) {
    this.code = enumValue;
    this.name = name;
    this.type = type;
  }

  public int id() {
    return code;
  }

  public String type() {
    return type;
  }

//  public String getName() {
//    return name;
//  }

//  public String getType() {
//    return type;
//  }

  public static int getCode(int code) {
    for (ItemCode ic : values()) {
      if (ic.code == code) {
        return ic.code;
      }
    }
    return -1;
  }

//  public static String getName(int code) {
//    for (ItemCode ic : values()) {
//      if (ic.code == code) {
//        return ic.name;
//      }
//    }
//    return "None";
//  }

  public static String getType(int code) {
    for (ItemCode ic : values()) {
      if (ic.code == code) {
        return ic.type;
      }
    }
    return "None";
  }

  public static boolean isFreePreItem(int itemId) {
    for (ItemCode e : values()) {
      if (StringUtils.startsWith(e.name(), "PREITEM") && StringUtils.contains(e.name(), "FREE") && e.id() == itemId) {
        return true;
      }
    }

    return false;
  }

  public static boolean isPaidPreItem(int itemId) {
    for (ItemCode e : values()) {
      if (StringUtils.startsWith(e.name(), "PREITEM") && StringUtils.contains(e.name(), "PAID") && e.id() == itemId) {
        return true;
      }
    }

    return false;
  }

  public static boolean isTimePreItem(int itemId) {
    for (ItemCode e : values()) {
      if (StringUtils.startsWith(e.name(), "PREITEM") && StringUtils.contains(e.name(), "TIME") && e.id() == itemId) {
        return true;
      }
    }

    return false;
  }

  public static boolean isFreeIngameItem(int itemId) {
    for (ItemCode e : values()) {
      if (StringUtils.startsWith(e.name(), "INGAME") && StringUtils.contains(e.name(), "FREE") && e.id() == itemId) {
        return true;
      }
    }

    return false;
  }

  public static boolean isPaidIngameItem(int itemId) {
    for (ItemCode e : values()) {
      if (StringUtils.startsWith(e.name(), "INGAME") && StringUtils.contains(e.name(), "PAID") && e.id() == itemId) {
        return true;
      }
    }

    return false;
  }

  public static int convertTimeToFree(int itemId) {
    int _id = 0;
    if (itemId == 1007001) {
      _id = ItemCode.PREITEM_FREE_MOVE.id();
    } else if (itemId == 1007002) {
      _id = ItemCode.PREITEM_FREE_MIX1.id();
    } else if (itemId == 1007003) {
      _id = ItemCode.PREITEM_FREE_CAULDRON.id();
    } else if (itemId == 1007004) {
      _id = ItemCode.PREITEM_FREE_SCORE.id();
    } else if (itemId == 1007005) {
      _id = ItemCode.PREITEM_FREE_CE_2.id();
    } else if (itemId == 1007006) {
      _id = ItemCode.PREITEM_FREE_CE_3.id();
    } else if (itemId == 1007007) {
      _id = ItemCode.PREITEM_FREE_CE_4.id();
    } else if (itemId == 1007008) {
      _id = ItemCode.PREITEM_FREE_BATTLE_CH.id();
    } else if (itemId == 1007009) {
      _id = ItemCode.PREITEM_FREE_BATTLE_SG.id();
    }

    return _id;
  }

}
