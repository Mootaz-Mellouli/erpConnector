package com.example.erpConnector.DBConnections.Controllers;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Entities.DatabaseRowInfo;
import com.example.erpConnector.DBConnections.Entities.DatabaseTableInfo;
import com.example.erpConnector.DBConnections.Services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping({"/database"})
public class DatabaseController {

    @Autowired
    DatabaseService databaseService ;

    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/info/{x}")
    public List<DatabaseTableInfo> getDatabaseTablesInfo(@PathVariable("x") String x)
    {
        return databaseService.getDatabaseTablesInfo(x);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/info/{tableName}/{dbName}")
    public List<DatabaseRowInfo> getDatabaseRowsInfo(@PathVariable("tableName")String tableName,@PathVariable("dbName") String dbName)
    {
        return databaseService.getDatabaseRowsInfo(tableName,dbName);
    }

    /*@PostMapping({"/save"})
    public List<DatabaseView> saveDatabaseInfo(String x)
    {
        return databaseService.saveDatabaseInfo(x);
    }*/

    @PostMapping({"/addinfo"})
    public DatabaseTableInfo addDatabaseinfo(@RequestBody DatabaseTableInfo databaseTableInfo)
    {
        return databaseService.addinfo(databaseTableInfo);
    }
}
