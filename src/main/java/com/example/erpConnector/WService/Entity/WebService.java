package com.example.erpConnector.WService.Entity;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WebService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id ;
    private String service_name ;
    private String database_name ;
    /*@ManyToOne
    private DatabaseConnection databaseConnection ;*/
    private String table_name ;
    @ElementCollection
    private List<String> column_name = new ArrayList<>();
    private String inputValue ;
    private String inputColumn ;
    private String operator ;
}
