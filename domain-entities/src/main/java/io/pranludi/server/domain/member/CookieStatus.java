package io.pranludi.server.domain.member;

public class CookieStatus {

  // _status = 0.locked, 1.not purchase, 2.purchased, 3.select
  public static int LOCK = 0;
  public static int UNLOCK = 1;
  public static int PURCHASED = 2;
  public static int SELECT = 3;

  // _effect (화면연출관련) = 0.locked, 1.unlock, 2. not purchased, 3.purchased, 4.select
  public static int EFFECT_LOCK = 0;
  public static int EFFECT_UNLOCK = 1;
  public static int EFFECT_NOT_PURCHASED = 2;
  public static int EFFECT_PURCHASED = 3;
  public static int EFFECT_SELECT = 4;

  // _pet_status = 1.not purchase, 2.purchased, 3.select
  public static int PET_NOT_PURCHASED = 1;
  public static int PET_PURCHASED = 2;
  public static int PET_SELECT = 3;

  // cookie, pet type
  public static int MAIN_EPISODE_COOKIE = 0;
  public static int SPECIAL_EPISODE_COOKIE = 1;
  public static int CHAMPIONS_LEAGUE_COOKIE = 2;
  public static int NEW_SEASON_CHALLENGE_COOKIE = 3;
  public static int FRIEND_INVITE_COOKIE = 4;
  public static int SINGLE_PET = 5; // 단독  펫
  public static int BATTLE_COOKIE = 6; // 배틀

}
