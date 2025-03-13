package io.pranludi.server.domain.root;

public class ServerConfig {

  public static final int MAX_TRY_COUNT = 10;
  public static final int RESULT_CASMISMATCH = 500;
  public static final int RESULT_EXCEPTION = 501;
  public static final int RESULT_ALREADY_EXISTS = 502;
  public static final int RESULT_OK = 200;
  public static final int MAX_HELP_PER_ONE_ASK = 5;
  public static final int TEAM_CHAT_MAX_LIST_SIZE = 1000;

  public static final boolean COUCHBASE_VIEW_DEVELOPMENT = false;

  public static final double COUCHBASE_RETRY_INIT = 0.1;
  public static final int COUCHBASE_RETRY_RATIO = 2;

  public static final int CRYSTAL_MAX_QTY = Integer.MAX_VALUE;
  public static final int COIN_MAX_QTY = Integer.MAX_VALUE;
  public static final int MEDAL_MAX_QTY = Integer.MAX_VALUE;
  public static final int PET_GACHA_MAX_QTY = Integer.MAX_VALUE;
  public static final int PET_SELECT_GACHA_MAX_QTY = Integer.MAX_VALUE;
  public static final int COMMON_GROW_MAX_QTY = Integer.MAX_VALUE;
  public static final int SPECIAL_GROW_MAX_QTY = Integer.MAX_VALUE;
  public static final int HIDDEN_STAGE_TICKET_MAX_QTY = Integer.MAX_VALUE;
  public static final int SURF_TICKET_MAX_QTY = Integer.MAX_VALUE;
  public static final int BATTLE_STAMINA_MAX_QTY = Integer.MAX_VALUE;

}
