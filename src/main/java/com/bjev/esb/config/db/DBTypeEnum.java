package com.bjev.esb.config.db;

public enum DBTypeEnum {

  localedb("localedb"), mesplat("mesplat");

  private String value;

  DBTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
