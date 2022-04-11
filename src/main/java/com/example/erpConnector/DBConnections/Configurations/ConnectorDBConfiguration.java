package com.example.erpConnector.DBConnections.Configurations;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "connectorEntityManagerFactory", transactionManagerRef = "connectorTransactionManager",
        basePackages = {"com.example.erpConnector.DBConnections.Repository"})
public class ConnectorDBConfiguration {

    @Primary
    @Bean(name = "connectorDataSourceProperties")
    @ConfigurationProperties("spring.datasource-connector")
    public DataSourceProperties connectorDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "connectorDataSource")
    public DataSource connectorDataSource()
    {
        return connectorDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "connectorEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean connectorEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        return entityManagerFactoryBuilder.dataSource(connectorDataSource())
                .packages(DatabaseConnection.class)
                .build();
    }

    @Primary
    @Bean(name = "connectorTransactionManager")
    public PlatformTransactionManager connectorTransactionManager(@Qualifier("connectorEntityManagerFactory") EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
