package com.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {
    @Value("${demo1.database.driver}")
    private String driver1;

    @Value("${demo1.database.url}")
    private String url1;

    @Value("${demo1.database.username}")
    private String username1;

    @Value("${demo1.database.password}")
    private String password1;

    @Value("${demo2.database.driver}")
    private String driver2;

    @Value("${demo2.database.url}")
    private String url2;

    @Value("${demo2.database.username}")
    private String username2;

    @Value("${demo2.database.password}")
    private String password2;

    @Primary
    @Bean("dataSource1")
    public DataSource dataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver1);
        dataSource.setUrl(url1);
        dataSource.setUsername(username1);
        dataSource.setPassword(password1);
        return dataSource;
    }

    @Bean("dataSource2")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver2);
        dataSource.setUrl(url2);
        dataSource.setUsername(username2);
        dataSource.setPassword(password2);
        return dataSource;
    }

    @Primary
    @Bean("namedParameterJdbcTemplate1")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate1(@Qualifier("dataSource1") DataSource dataSource1) {
        return new NamedParameterJdbcTemplate(dataSource1);
    }

    @Bean("namedParameterJdbcTemplate2")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource2) {
        return new NamedParameterJdbcTemplate(dataSource2);
    }
}
