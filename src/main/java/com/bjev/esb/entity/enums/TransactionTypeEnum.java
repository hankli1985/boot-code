package com.bjev.esb.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum TransactionTypeEnum {
  EachData(1, "每条数据"), WholeData(2, "整笔数据");

  @EnumValue
  private final Integer code;
  private final String descp;

  TransactionTypeEnum(Integer code, String descp) {
    this.code = code;
    this.descp = descp;
  }

  public Integer getCode() {
    return code;
  }

  public String getDescp() {
    return descp;
  }

  @Override
  public String toString() {
    return descp;
  }
}
