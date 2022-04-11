package com.example.erpConnector.DBConnections.Controllers;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/database"})
public class DatabaseController {

    @Autowired
    DatabaseService databaseService ;

    @GetMapping({"/"})
    public List<DatabaseConnection> getAllDatabases()
    {
        return databaseService.getAllDatabases();
    }

    @PostMapping({"/add"})
    public DatabaseConnection addDatabase(@RequestBody DatabaseConnection databaseConnection)
    {
        return databaseService.addDatabase(databaseConnection);
    }
}
