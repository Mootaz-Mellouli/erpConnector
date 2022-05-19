package com.example.erpConnector.WService.Configurations;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
/*@EnableTransactionManagement*/
/*@EnableJpaRepositories(entityManagerFactoryRef = "EntityManagerFactory", transactionManagerRef = "TransactionManager",
        basePackages = {"com.example.erpConnector.WService.Repository"})*/
public class CustomDataSourceConfiguration {

    private String url ;
    private String username ;
    private String password ;

    public void setUrl(String url)
    {
        this.url=url ;
    }

    public void setUsername(String username){this.username=username;}

    public void setPassword(String password){this.password=password;}

    @Bean
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @ConfigurationProperties("spring.second-datasource")
    public DataSource customDataSource()
    {
        DriverManagerDataSource dataSourceProperties = new DriverManagerDataSource();
        dataSourceProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceProperties.setUrl(url);
        System.out.println(url);
        dataSourceProperties.setUsername(username);
        dataSourceProperties.setPassword(password);
        return dataSourceProperties;
    }

    @Bean
    @Lazy
    @Qualifier("customJdbcTemplate")
    public JdbcTemplate customJdbcTemplate(@Qualifier("customDataSource") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    /*@Lazy
    @Bean(name = "EntityManagerFactory")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        setUrl("jdbc:mysql://localhost:3306/managers");
        setUsername("root");
        setPassword("");
        return entityManagerFactoryBuilder.dataSource(customDataSource())
                .packages("com.example.erpConnector")
                .build();
    }

    @Lazy
    @Bean(name = "TransactionManager")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PlatformTransactionManager TransactionManager(@Qualifier("EntityManagerFactory") EntityManagerFactory entityManagerFactory)
    {

        return new JpaTransactionManager(entityManagerFactory);
    }*/


}
