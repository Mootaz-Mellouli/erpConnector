package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Database {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer db_ID ;
    private String db_hostname ;
    private String db_username ;
    private String db_password ;
    private DBType db_type ;
    private String db_name ;

}
