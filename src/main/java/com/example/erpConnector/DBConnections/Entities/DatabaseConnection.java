package com.example.erpConnector.DBConnections.Entities;

import com.example.erpConnector.WService.Entity.WebService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class DatabaseConnection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dbID ;
    private String db_hostname ;
    private String db_username ;
    private String db_password ;
    @Enumerated(EnumType.STRING)
    private DBType db_type ;
    private String dbname ;
    @OneToMany(cascade=CascadeType.ALL)
    //@JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<WebService> webServiceList;
    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "services_list",
    joinColumns = @JoinColumn(referencedColumnName = "dbID",name = "database_name_db"),
    inverseJoinColumns = @JoinColumn(name = "database_name_service",referencedColumnName = "service_id"))
    private List<WebService> webServiceList ;*/

}
