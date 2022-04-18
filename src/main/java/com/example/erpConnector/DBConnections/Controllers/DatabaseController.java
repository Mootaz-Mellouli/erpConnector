package com.example.erpConnector.DBConnections.Controllers;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseView;
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

    @GetMapping({"/info"})
    public List<DatabaseView> getDatabaseInfo()
    {
        return databaseService.getDatabaseView();
    }

    @PostMapping({"/save"})
    public List<DatabaseView> saveDatabaseInfo()
    {
        return databaseService.saveDatabaseInfo();
    }

    @PostMapping({"/addinfo"})
    public DatabaseView addDatabaseinfo(@RequestBody DatabaseView databaseView)
    {
        return databaseService.addinfo(databaseView);
    }
}
