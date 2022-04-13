package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DatabaseView {

    @Id
    private String column_name ;
    private String database_schema ;
    private String column_id ;
    private String data_type ;
    private String table_name ;

}
