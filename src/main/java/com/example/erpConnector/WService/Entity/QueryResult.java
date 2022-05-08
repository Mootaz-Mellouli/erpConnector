package com.example.erpConnector.WService.Entity;

import lombok.Data;

import javax.persistence.Entity;;
import javax.persistence.Id;

@Entity
@Data
public class QueryResult {

    @Id
    private String first_name ;


}
