package com.example.erpConnector.WService.Configurations;


import com.example.erpConnector.DBConnections.Configurations.ConnectorDBConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


//@Component(value = "DataSourceRouting")
//public class DataSourceRouting extends AbstractRoutingDataSource {

    /*private DataSourceOneConfig dataSourceOneConfig ;
    private DataSourceTwoConfig dataSourceTwoConfig ;
    private DataSourceContexHolder dataSourceContexHolder ;
    private ConnectorDBConfiguration connectorDBConfiguration ;
    //private String x = "jdbc:mysql://localhost:3306/customer" ;

    private String routInput ;*/

   /* public  DataSourceRouting(  DataSourceContexHolder dataSourceContexHolder  , DataSourceTwoConfig dataSourceTwoConfig,ConnectorDBConfiguration connectorDBConfiguration)
    {
        this.dataSourceContexHolder=dataSourceContexHolder ;
      //  this.dataSourceOneConfig = dataSourceOneConfig ;
        this.dataSourceTwoConfig = dataSourceTwoConfig ;
        this.connectorDBConfiguration=connectorDBConfiguration;
        Map<Object,Object> dataSourceMap = new HashMap<>();
       // dataSourceMap.put(DataSourceEnum.DataSourceONE,dataSourceTwoDataSource());
        //dataSourceMap.put(DataSourceEnum.DataSourceTWO,dataSourceTwoDataSource());
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(connectorDBConfiguration.dataSourceByDefault());

    }*/

   /* @Bean
    public void dataRouting()
    {


    }*/
   /* public void setX(String x)
    {
        this.x=x;
    }*/
    /*public void setRoutInput(String routInput)
    {
        this.routInput=routInput;
    }
    //@Bean(name = "DataSourceOneProperties")
    @ConfigurationProperties("datasourceone.datasource")
    public DataSource DataSourceOneProperties()
    {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/customer");
        dataSourceProperties.setUsername(routInput);
        //dataSourceProperties.determineUsername();
        dataSourceProperties.setPassword("");
        dataSourceProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }*/

  /*  @Bean(name = "dataSourceONE")
    public DataSource dataSourceONE()
    {
        return DataSourceOneProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }*/





    /*public DataSource dataSourceOneDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dataSourceTwoConfig.getUrl());
        driverManagerDataSource.setPassword(dataSourceTwoConfig.getPassword());
        driverManagerDataSource.setUsername(dataSourceTwoConfig.getUsername());
        return  driverManagerDataSource ;
    }
*/
   /* @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContexHolder.getBranchContext();
    }*/
//}
