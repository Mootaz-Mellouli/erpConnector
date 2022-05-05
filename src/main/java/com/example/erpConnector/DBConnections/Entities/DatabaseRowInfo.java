package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DatabaseRowInfo {

    @Id
    private String column_name ;
    private String data_type ;
}
