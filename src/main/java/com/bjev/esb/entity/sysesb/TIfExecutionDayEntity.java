package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfExecutionDayEntity {
  private Long pkId;
  private String day;
  private String ifCode;
  private Integer autoSuccess;
  private Integer autoTotal;
  private Integer handSuccess;
  private Integer handTotal;
}