package com.example.erpConnector.DBConnections.Services;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseView;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import com.example.erpConnector.DBConnections.Repository.DatabaseViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository ;

    @Autowired
    DatabaseViewRepository databaseViewRepository ;

    public List<DatabaseConnection> getAllDatabases()
    {
        return databaseRepository.findAll();
    }

    public DatabaseConnection addDatabase(DatabaseConnection databaseConnection)
    {
        return databaseRepository.save(databaseConnection);
    }

    public Collection<DatabaseView> getDatabaseView()
    {
        return databaseViewRepository.getDataBaseInfo();
    }
}
