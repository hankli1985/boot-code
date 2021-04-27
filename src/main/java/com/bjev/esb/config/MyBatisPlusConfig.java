package com.bjev.esb.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.bjev.esb.config.db.DBTypeEnum;
import com.bjev.esb.config.db.DynamicDataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis plus config
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.bjev.esb.mapper.**")
public class MyBatisPlusConfig {
  /**
   * 配置mybatis-plus 分页查件
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    return paginationInterceptor;
  }

  /**
   * 
   */
  @Bean(name = "localedb")
  @ConfigurationProperties(prefix = "spring.datasource.druid.localedb")
  public DataSource localedb() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(name = "mesplat")
  @ConfigurationProperties(prefix = "spring.datasource.druid.mesplat")
  public DataSource mesplat() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean
  @Primary
  public DataSource multipDataSource(@Qualifier("localedb") DataSource localedb,
      @Qualifier("mesplat") DataSource mesplat) {
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    Map<Object, Object> targetDataSources = new HashMap<>();
    targetDataSources.put(DBTypeEnum.localedb.getValue(), localedb);
    targetDataSources.put(DBTypeEnum.mesplat.getValue(), mesplat);
    dynamicDataSource.setTargetDataSources(targetDataSources);
    dynamicDataSource.setDefaultTargetDataSource(localedb);
    return dynamicDataSource;
  }

  // @Bean
  // public GlobalConfig globalConfig(){
  // gl
  // }
}