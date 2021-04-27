package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfExecutionQuarterEntity {
  private Long pkId;
  private String quarter;
  private String ifCode;
  private Integer autoSuccess;
  private Integer autoTotal;
  private Integer handSuccess;
  private Integer handTotal;
}