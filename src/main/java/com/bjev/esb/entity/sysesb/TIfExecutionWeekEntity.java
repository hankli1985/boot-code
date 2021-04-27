package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfExecutionWeekEntity {
  private Long pkId;
  private String week;
  private String ifCode;
  private Integer autoSuccess;
  private Integer autoTotal;
  private Integer handSuccess;
  private Integer handTotal;
}