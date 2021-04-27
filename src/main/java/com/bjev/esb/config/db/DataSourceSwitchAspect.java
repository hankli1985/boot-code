package com.bjev.esb.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = -100)
@Aspect
public class DataSourceSwitchAspect {
  @Pointcut("execution(* com.bjev.esb.mapper.localedb..*.*(..))")
  private void localedbAspect() {
  }

  @Pointcut("execution(* com.bjev.esb.mapper.mesplat..*.*(..))")
  private void mesplatAspect() {
  }

  // @Pointcut("execution(* com.df.openapi.*.mapper.db3..*.*(..))")
  // private void db3Aspect() {
  // }

  @Before("localedbAspect()")
  public void localedb() {
    // System.out.println("==================================");
    // log.info("切换到localedb 数据源...");
    DbContextHolder.setDbType(DBTypeEnum.localedb);
  }

  @Before("mesplatAspect()")
  public void mesplat() {
    // System.out.println("----------------------------------");
    // log.info("切换到mesplat 数据源...");
    DbContextHolder.setDbType(DBTypeEnum.mesplat);
  }

  // @Before("db3Aspect()")
  // public void db3() {
  // log.info("切换到db3 数据源...");
  // DbContextHolder.setDbType(DBTypeEnum.db3);
  // }

}
