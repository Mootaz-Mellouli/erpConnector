package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class DatabaseView {


    private String column_name ;
    private String database_schema ;
    @Id
    private int column_id ;
    private String data_type ;
    private String table_name ;

}
