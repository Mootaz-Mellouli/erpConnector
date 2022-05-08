package com.example.erpConnector.WService.Entity;

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
    private String table_name ;
    @ElementCollection(fetch = FetchType.EAGER) //temporary solution.
    private List<String> column_name = new ArrayList<>();
    private String inputValue ;
    private String inputColumn ;
}
