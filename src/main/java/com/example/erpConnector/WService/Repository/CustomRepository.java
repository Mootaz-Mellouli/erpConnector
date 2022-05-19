package com.example.erpConnector.WService.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
@Lazy
@ComponentScan(basePackages = "com.example.erpConnector.WService")
public class CustomRepository {

    @Autowired
    @Qualifier("customJdbcTemplate")
    private JdbcTemplate jdbcTemplate ;

    @Autowired
    ApplicationContext applicationContext ;

    public void refreshCustomJdbc() {
        DataSource ds = (DataSource) applicationContext.getBean("customDataSource");
        JdbcTemplate customJdbcTemplate = (JdbcTemplate) applicationContext.getBean("customJdbcTemplate");
        customJdbcTemplate.setDataSource(ds);
        try {
            boolean test = ds.getConnection().isValid(0);
            System.out.println("DATABASE TEST : " + test);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
