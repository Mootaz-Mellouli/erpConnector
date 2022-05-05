package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DatabaseTableInfo {

    @Id
    private String table_name ;
    private String database_name ;
}
