package com.example.erpConnector.DBConnections.Entities;

import com.example.erpConnector.WService.Entity.WebService;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "database_name")
    private WebService servicesList ;

}
