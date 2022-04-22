package com.example.erpConnector.DBConnections.Services;

import com.example.erpConnector.DBConnections.Configurations.ConnectorDBConfiguration;
import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseView;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseViewRepository;
import com.example.erpConnector.WService.Configurations.DataSourceConfig;
import com.example.erpConnector.WService.Configurations.DataSourceOneConfig;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository ;

    @Autowired
    DatabaseViewRepository databaseViewRepository ;

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

    public List<DatabaseView> getDatabaseView()
    {
        return databaseViewRepository.getDataBaseInfo();
    }

    public List<DatabaseView> saveDatabaseInfo()
    {

        List<DatabaseView> databaseView = databaseViewRepository.getDataBaseInfo();
        for(int i = 0 ; i <databaseView.size();i++) {
             databaseViewRepository.save(databaseView.get(i));
        }
       // return  databaseViewRepository.saveAll(databaseView);
        return databaseView ;
    }

    public DatabaseView addinfo(DatabaseView databaseView)
    {
        return databaseViewRepository.save(databaseView);
    }

}
