package com.example.erpConnector.WService.Configurations;

import com.example.erpConnector.DBConnections.Configurations.ConnectorDBConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "EntityManagerFactory", transactionManagerRef = "TransactionManager",
        basePackages = {"com.example.erpConnector.WService.Repository"})
//@RequiredArgsConstructor
//@DependsOn("DatabaseService")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DataSourceConfig {

    //private final DataSourceRouting dataSourceRouting ;
    ConnectorDBConfiguration connectorDBConfiguration ;

    private String routInput ;

    @Autowired
    public DataSourceConfig(ConnectorDBConfiguration connectorDBConfiguration) {
        this.connectorDBConfiguration = connectorDBConfiguration;
    }

   /* @Bean
    public DataSource dataSourceTwoDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/customer");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setUsername("root");
        return  driverManagerDataSource ;

    }*/
    public void setRoutInput(String routInput)
    {
        this.routInput=routInput;
    }


    @Bean(name = "dataSourceDataSourceProperties")
    @ConfigurationProperties("datasourceone.datasource")
    public DataSource dataSourceDataSourceProperties()
    {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/customer");
        dataSourceProperties.setUsername("");
        dataSourceProperties.setPassword("");
        //dataSourceProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();

    }

   /* @Bean(name = "dataSourceDataSource")
    public DataSource dataSourceDataSource()
    {
        return dataSourceDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }*/


    @Bean(name = "dataSource")
    public DataSource dataSource()
    {
        DataSourceAbstractRouting dataSourceAbstractRouting = new DataSourceAbstractRouting();
        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.DataSourceONE,dataSourceDataSourceProperties());
        dataSourceMap.put(DataSourceEnum.DataSourceTWO,dataSourceDataSourceProperties());
        dataSourceAbstractRouting.setTargetDataSources(dataSourceMap);
        dataSourceAbstractRouting.setDefaultTargetDataSource(connectorDBConfiguration.dataSourceByDefault());
        return dataSourceAbstractRouting ;
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
