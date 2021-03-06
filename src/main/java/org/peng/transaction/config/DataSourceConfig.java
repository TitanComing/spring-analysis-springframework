package org.peng.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * Create by peng on 2021/6/15.
 */
@Configuration
//开启事务注解
@EnableTransactionManagement
public class DataSourceConfig {

    //数据源
    @Bean
    public DataSource getDataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/transaction/h2-schema.sql", "classpath:sql/transaction/h2-data.sql")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建数据库连接失败");
            return null;
        }
    }

    //jdbc操作类
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    //带事务的数据源管理类-编程式事务
    @Bean
    public PlatformTransactionManager getTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(getDataSource());
        return  transactionManager;
    }

    //带事物的jdbc操作类-编程式事务-编程式事务更推荐，一般用的是声明式事务，也就是@Transactional注解
    @Bean
    public TransactionTemplate getTransactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(getTransactionManager());
        return transactionTemplate;
    }

}
