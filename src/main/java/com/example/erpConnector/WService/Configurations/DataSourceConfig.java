package com.example.erpConnector.WService.Configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "EntityManagerFactory", transactionManagerRef = "TransactionManager",
        basePackages = {"com.example.erpConnector.WService.Repository"})
@RequiredArgsConstructor
@DependsOn("DataSourceRouting")
public class DataSourceConfig {

    private final DataSourceRouting dataSourceRouting ;

    @Bean
    public DataSource dataSource()
    {
        return dataSourceRouting ;
    }

    @Bean(name = "EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        return entityManagerFactoryBuilder.dataSource(dataSource())
                .packages("com.example.erpConnector.WService.Entity")
                .build();
    }

    @Bean(name = "TransactionManager")
    public JpaTransactionManager connectorTransactionManager(@Qualifier("EntityManagerFactory")  LocalContainerEntityManagerFactoryBean EntityManagerFactory)
    {
        return new JpaTransactionManager(EntityManagerFactory.getObject());
    }
}
