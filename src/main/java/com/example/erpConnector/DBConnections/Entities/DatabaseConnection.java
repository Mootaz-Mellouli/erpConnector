package com.example.erpConnector.DBConnections.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DatabaseConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String db_hostname ;
    private String db_username ;
    private String db_password ;
    @Enumerated(EnumType.STRING)
    private DBType db_type ;
    private String db_name ;

}
