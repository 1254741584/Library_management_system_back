package com.yis.lms;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@MapperScan("com.yis.lms.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringSourceCode1Application{

	public static void main(String[] args) {
		
		SpringApplication.run(SpringSourceCode1Application.class, args);
	}
	
	/*
     * 用阿里连接池druid
	 */
//    @Bean(destroyMethod = "close", initMethod = "init")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
}
