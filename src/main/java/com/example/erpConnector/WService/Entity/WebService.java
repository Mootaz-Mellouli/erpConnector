package com.example.erpConnector.WService.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class WebService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String service_name ;
    private String database_name ;
    private String table_name ;
    private String row_name ;
    private String inputValue ;
    private String inputRow ;
}
