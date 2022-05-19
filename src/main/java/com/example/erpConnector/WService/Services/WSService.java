package com.example.erpConnector.WService.Services;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import com.example.erpConnector.DBConnections.Repository.DatabaseRepository;
import com.example.erpConnector.WService.Configurations.CustomDataSourceConfiguration;
import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Repository.CustomRepository;
import com.example.erpConnector.WService.Repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class WSService {

    @Autowired
    WebServiceRepository webServiceRepository ;

    @Autowired
    EntityManager entityManager ;

    @Autowired
    DatabaseRepository databaseRepository ;

    @Autowired
    CustomDataSourceConfiguration dataSourceConfiguration ;

    @Autowired
    ApplicationContext applicationContext ;

    @Autowired
    CustomRepository customRepository ;

    @Autowired
    @Qualifier("customJdbcTemplate")
    private JdbcTemplate jdbcTemplate ;

    public WebService addWebService(WebService webService)
    {
        return webServiceRepository.save(webService);
    }

    public List<WebService> getAllWebServices()
    {
       /* entityManager.getTransaction().begin();
        TypedQuery<WebService> query = entityManager.createQuery("select  a from WebService a left join fetch a.webservice_column_name",WebService.class);*/
        return webServiceRepository.findAll();
    }

    public List callService (Integer id)
    {


        Optional<WebService> webService ;
        /* * * * * * * je stock le service dans la variable webService  */
        webService= webServiceRepository.findById(id);
        DatabaseConnection database= databaseRepository.findDatabaseConnectionByDbname(webService.get().getDatabase_name());
        String url = database.getDb_hostname();
        String username = database.getDb_username();
        String password = database.getDb_password();
        dataSourceConfiguration.setUrl(url);
        dataSourceConfiguration.setUsername(username);
        dataSourceConfiguration.setPassword(password);
        customRepository.refreshCustomJdbc();



        //Query query=entityManager.createNativeQuery("select :x from customer  where customer_id=1");
        /* * * * * * * je stock la list des colonnes dans la variable columnsNames  */
        List columnNames=webService.get().getColumn_name();
        String tableName=webService.get().getTable_name();
        String inputColumn=webService.get().getInputColumn();
        String inputValue=webService.get().getInputValue();
        String operateur=webService.get().getOperator();
       // Query query=entityManager.createNativeQuery("select "+ "".join(",",columnNames) +" from "+ tableName+ " where "+ inputColumn + " "+operateur+" " + inputValue+"");
        List queryresult = jdbcTemplate.queryForList("select "+ "".join(",",columnNames) +" from "+ tableName+ " where "+ inputColumn + " "+operateur+" " + inputValue+"");
       // String queryString = query.toString();
       // customRepository.setQuery(queryString);
        //List test = customRepository.test();
        System.out.println("this is a test "+queryresult);
        /* * * ici je passe la variable comme un parametre dans la requete */
        //query.setParameter("x",oneColumn);
        /* * execution du requete */
       // List queryReslt = query.getResultList();
        return queryresult ;
    }

    public void deleteService(Integer id)
    {
        webServiceRepository.deleteById(id);
    }



}
