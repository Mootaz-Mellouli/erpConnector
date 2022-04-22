package com.example.erpConnector.WService.Configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceAbstractRouting extends AbstractRoutingDataSource {

    @Autowired
    DataSourceContexHolder dataSourceContexHolder ;

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContexHolder.getBranchContext();
    }
}
