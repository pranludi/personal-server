package io.pranludi.server.member.service;

import io.pranludi.server.domain.member.Member;
import io.pranludi.server.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MigrationService {

  @Autowired
  MetadataService metadataService;

  public Member migration(Member oldMember) {
    int currentVersion = metadataService.currentMemberVersion();
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
