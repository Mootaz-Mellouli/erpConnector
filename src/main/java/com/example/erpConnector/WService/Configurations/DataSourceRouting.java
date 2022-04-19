package com.example.erpConnector.WService.Configurations;


import com.example.erpConnector.DBConnections.Configurations.ConnectorDBConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component(value = "DataSourceRouting")
public class DataSourceRouting extends AbstractRoutingDataSource {

    private DataSourceOneConfig dataSourceOneConfig ;
    private DataSourceTwoConfig dataSourceTwoConfig ;
    private DataSourceContexHolder dataSourceContexHolder ;


    private ConnectorDBConfiguration connectorDBConfiguration ;

    public  DataSourceRouting(DataSourceContexHolder dataSourceContexHolder , DataSourceOneConfig dataSourceOneConfig , DataSourceTwoConfig dataSourceTwoConfig,ConnectorDBConfiguration connectorDBConfiguration)
    {
        this.dataSourceContexHolder=dataSourceContexHolder ;
        this.dataSourceOneConfig = dataSourceOneConfig ;
        this.dataSourceTwoConfig = dataSourceTwoConfig ;
        this.connectorDBConfiguration=connectorDBConfiguration;

        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.DataSourceONE,dataSourceOneDataSource());
        dataSourceMap.put(DataSourceEnum.DataSourceTWO,dataSourceTwoDataSource());
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(connectorDBConfiguration.dataSourceByDefault());
    }

    public DataSource dataSourceTwoDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dataSourceOneConfig.getUrl());
        driverManagerDataSource.setPassword(dataSourceOneConfig.getPassword());
        driverManagerDataSource.setUsername(dataSourceOneConfig.getUsername());
        return  driverManagerDataSource ;

    }

    public DataSource dataSourceOneDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dataSourceTwoConfig.getUrl());
        driverManagerDataSource.setPassword(dataSourceTwoConfig.getPassword());
        driverManagerDataSource.setUsername(dataSourceTwoConfig.getUsername());
        return  driverManagerDataSource ;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContexHolder.getBranchContext();
    }
}
