package com.example.erpConnector.DBConnections.Services;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseRowInfo;
import com.example.erpConnector.DBConnections.Entities.DatabaseTableInfo;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseRowInfoRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseTableInfoRepository;
import com.example.erpConnector.WService.Configurations.DataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository ;

    @Autowired
    DatabaseTableInfoRepository databaseTableInfoRepository;

    @Autowired
    DatabaseRowInfoRepository databaseRowInfoRepository ;

    /*@Autowired
    ConnectorDBConfiguration connectorDBConfiguration ;*/
   /* @Autowired
    DataSourceOneConfig dataSourceOneConfig ;*/
@Autowired
DataSourceConfig dataSourceConfig ;
   // DataSourceRouting dataSourceRouting ;

    /*@Autowired
    public DatabaseService(@Qualifier("DataSourceRouting") DataSourceRouting drs)
    {
        this.dataSourceRouting=drs;
    }*/

    public List<DatabaseConnection> getAllDatabases()
    {
        return databaseRepository.findAll();
    }

    public DatabaseConnection addDatabase(DatabaseConnection databaseConnection)
    {
        //connectorDBConfiguration.connectorDataSourceProperties().setUrl(databaseConnection.getDb_hostname());
        /*dataSourceOneConfig.setUrl(databaseConnection.getDb_hostname());*/
        dataSourceConfig.setRoutInput(databaseConnection.getDb_username());
      //this.dataSourceRouting.setRoutInput(databaseConnection.getDb_username().toString());
        return databaseRepository.save(databaseConnection);
    }

    public List<DatabaseTableInfo> getDatabaseTablesInfo(String x)
    {
        return databaseTableInfoRepository.getDataBaseTableInfo(x);
    }

    public List<DatabaseRowInfo> getDatabaseRowsInfo(String dbName,String tableName)
    {
        return databaseRowInfoRepository.getDataBaseRowInfo(tableName,dbName);
    }

    /*public List<DatabaseView> saveDatabaseInfo()
    {

        List<DatabaseView> databaseView = databaseViewRepository.getDataBaseInfo();
        for(int i = 0 ; i <databaseView.size();i++) {
             databaseViewRepository.save(databaseView.get(i));
        }
       // return  databaseViewRepository.saveAll(databaseView);
        return databaseView ;
    }
*/
    public DatabaseTableInfo addinfo(DatabaseTableInfo databaseTableInfo)
    {
        return databaseTableInfoRepository.save(databaseTableInfo);
    }

}
