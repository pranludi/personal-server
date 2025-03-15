package io.pranludi.server.domain.entity;

public enum ItemType {
  Currency1("Currency1"), Currency2("Currency2"), Item1("Item1"), Item2("Item2");

  private final String value;

  ItemType(String value) {
    this.value = value;
  }
}
