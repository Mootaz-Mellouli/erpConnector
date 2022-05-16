package com.example.erpConnector.WService.Services;

import com.example.erpConnector.WService.Entity.QueryResult;
import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Repository.ExtractionServiceRepository;
import com.example.erpConnector.WService.Repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WSService {

    @Autowired
    WebServiceRepository webServiceRepository ;

    @Autowired
    ExtractionServiceRepository extractionServiceRepository ;

    @Autowired
    EntityManager entityManager ;

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
        //Query query=entityManager.createNativeQuery("select :x from customer  where customer_id=1");
        /* * * * * * * je stock la list des colonnes dans la variable columnsNames  */
        List columnNames=webService.get().getColumn_name();
        String tableName=webService.get().getTable_name();
        String inputColumn=webService.get().getInputColumn();
        String inputValue=webService.get().getInputValue();
        String operateur=webService.get().getOperator();
        Query query=entityManager.createNativeQuery("select "+ "".join(",",columnNames) +" from "+ tableName+ " where "+ inputColumn + " "+operateur+" " + inputValue+"");
        /* * * ici je passe la variable comme un parametre dans la requete */
        //query.setParameter("x",oneColumn);
        /* * execution du requete */
        List queryReslt = query.getResultList();
        return queryReslt ;
    }
    public void deleteService(Integer id)
    {
        webServiceRepository.deleteById(id);
    }



}
