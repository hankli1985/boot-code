package com.bjev.esb.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum ServiceTypeEnum {
  WebService("WS", "WebService协议"), RESTFul("Rest", "RestFul风格");

  @EnumValue
  private final String code;
  private final String descp;

  ServiceTypeEnum(String code, String descp) {
    this.code = code;
    this.descp = descp;
  }

  public String getCode() {
    return code;
  }

  public String getDescp() {
    return descp;
  }

  @Override
  public String toString() {
    return name();
  }

}
