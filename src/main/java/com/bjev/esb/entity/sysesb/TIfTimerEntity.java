package com.bjev.esb.entity.sysesb;

import java.util.Date;

import lombok.Data;

@Data
public class TIfTimerEntity {
  private String jobCode;
  private String jobDesc;
  private String ifCode;
  private String masterQueryTableId;
  private String jobGroup;
  private String jobClass;
  private String triggerName;
  private String triggerValue;
  private Date startTime;
  private Integer updateState;
  private Integer runState;
  private Date lastRunTime;
  private Date nextRunTime;
  private Integer threadState;
  private Date threadRunTime;

}
