package com.example.erpConnector.DBConnections.Services;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository ;

    public List<DatabaseConnection> getAllDatabases()
    {
        return databaseRepository.findAll();
    }

    public DatabaseConnection addDatabase(DatabaseConnection databaseConnection)
    {
        return databaseRepository.save(databaseConnection);
    }
}
