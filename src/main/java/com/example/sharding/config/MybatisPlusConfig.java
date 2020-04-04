package com.example.sharding.config;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.sharding.ShardingDemoApplication;

/**
 *@DATE Apr 4, 2020
 *@AUTHOR michael
 *@DESC  
 */
@Configuration
@MapperScan("com.example.sharding.mapper")
public class MybatisPlusConfig {
	
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    
    @Bean(name = "dataSource")
    public DataSource dataSourceBean() {
    	return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
         MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
         bean.setDataSource(dataSource);
         try {
             return bean.getObject();
         } catch (Exception e) {
             e.printStackTrace();
             throw new RuntimeException(e);
         }
     }
     @Bean
     public SqlSessionTemplate sqlSessionTemplate() {
        return new SqlSessionTemplate(sqlSessionFactory);
     }

    /**
     * 分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
}
