package org.peng.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Create by peng on 2021/6/17.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
    //数据源
    @Bean
    public DataSource getDataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/mvc/h2-schema.sql", "classpath:sql/mvc/h2-data.sql")
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
}
