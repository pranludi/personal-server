package io.pranludi.server.entity;

import io.pranludi.server.domain.entity.MemberId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {

  @Id
  private String memberId;
  private byte[] member;

  public User() {
  }

  public User(MemberId memberId, byte[] member) {
    this.memberId = memberId.memberId();
    this.member = member;
  }

  public byte[] getMember() {
    return member;
  }

  public void setMember(byte[] member) {
    this.member = member;
  }
}
