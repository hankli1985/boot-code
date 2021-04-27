package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfExecutionMonthEntity {
  private Long pkId;
  private String month;
  private String ifCode;
  private Integer autoSuccess;
  private Integer autoTotal;
  private Integer handSuccess;
  private Integer handTotal;
}