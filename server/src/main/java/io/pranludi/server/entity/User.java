package io.pranludi.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {

  @Id
  private String memberId;
  private byte[] member;

  public User() {
  }

  public User(String memberId, byte[] member) {
    this.memberId = memberId;
    this.member = member;
  }

  public String getMemberId() {
    return memberId;
  }

  public byte[] getMember() {
    return member;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public void setMember(byte[] member) {
    this.member = member;
  }
}
