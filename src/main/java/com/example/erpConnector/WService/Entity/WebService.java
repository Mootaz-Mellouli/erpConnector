package com.example.erpConnector.WService.Entity;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WebService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String service_name ;
    private String database_name ;
    @OneToMany(mappedBy = "servicesList")
    @JsonIgnore
    private List<DatabaseConnection> services = new ArrayList<>() ;
    private String table_name ;
    @ElementCollection(fetch = FetchType.EAGER) //temporary solution.
    private List<String> column_name = new ArrayList<>();
    private String inputValue ;
    private String inputColumn ;
    private String operator ;
}
