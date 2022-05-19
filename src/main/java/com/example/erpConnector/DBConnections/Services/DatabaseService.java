package com.example.erpConnector.DBConnections.Services;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseRowInfo;
import com.example.erpConnector.DBConnections.Entities.DatabaseTableInfo;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseRowInfoRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseTableInfoRepository;

import com.example.erpConnector.WService.Configurations.CustomDataSourceConfiguration;
import com.example.erpConnector.WService.Repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository ;

    @Autowired
    DatabaseTableInfoRepository databaseTableInfoRepository;

    @Autowired
    DatabaseRowInfoRepository databaseRowInfoRepository ;

    @Autowired
    CustomDataSourceConfiguration dataSourceConfiguration ;

    @Autowired
    ApplicationContext applicationContext ;

    @Autowired
    EntityManager entityManager ;

    @Autowired
    CustomRepository customRepository ;

    /*@Autowired
    ConnectorDBConfiguration connectorDBConfiguration ;*/
   /* @Autowired
    DataSourceOneConfig dataSourceOneConfig ;*/


    /*@Autowired
    DataSourceConfig dataSourceConfig ;*/
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
       // dataSourceConfig.setRoutInput(databaseConnection.getDb_username());
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

    public void deleteDBConnection(Integer id)
    {
        databaseRepository.deleteById(id);
    }

    public DatabaseConnection updateDBConnection (DatabaseConnection databaseConnection , Integer id)
    {
        DatabaseConnection dbConn = databaseRepository.findDatabaseConnectionByDbID(id);
        dbConn.setDbname(databaseConnection.getDbname());
        dbConn.setDb_type(databaseConnection.getDb_type());
        dbConn.setDb_password(databaseConnection.getDb_password());
        dbConn.setDb_hostname(databaseConnection.getDb_hostname());
        dbConn.setDb_username(databaseConnection.getDb_username());
        return databaseRepository.save(dbConn);
    }

    /*public void testDBConnection(Integer id)
    {

        Query query = entityManager.createNativeQuery("SHOW DATABASES LIKE :dbName");
        DatabaseConnection dbConn = databaseRepository.findDatabaseConnectionByDbID(id);
        String dbName = dbConn.getDbname();
        query.setParameter("dbName",dbName);
        List queryReslt = query.getResultList();
        if (queryReslt.isEmpty()){
            System.out.println(queryReslt);
            System.out.println("database not found");}
        else {
            System.out.println(queryReslt);
        dataSourceConfiguration.setUrl(dbConn.getDb_hostname());
        //refreshCustomJdbc();
            customRepository.refreshCustomJdbc();
        }

    }*/

    /*public void refreshCustomJdbc() {
        DataSource ds = (DataSource) applicationContext.getBean("customDataSource");
        JdbcTemplate customJdbcTemplate = (JdbcTemplate) applicationContext.getBean("customJdbcTemplate");
        customJdbcTemplate.setDataSource(ds);
        try {
            boolean test = ds.getConnection().isValid(0);
            System.out.println("DATABASE TEST : " + test);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
