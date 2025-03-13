package io.pranludi.server.logic;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.domain.metadata.Metadata;

public class MigrationLogic {

  public static Member migration(Member oldMember, Metadata metadata) {
    int currentVersion = metadata.currentMemberVersion();
    for (int ver = oldMember.version(); ver <= currentVersion; ver++) {
      switch (ver) {
        case 0:
          break;
        case 1:
          break;
        case 2:
          break;
      }
    }

    oldMember.withVersion(currentVersion);

    return oldMember;
  }

}
