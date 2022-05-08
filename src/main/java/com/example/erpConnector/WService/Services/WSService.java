package com.example.erpConnector.WService.Services;

import com.example.erpConnector.WService.Entity.QueryResult;
import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Repository.ExtractionServiceRepository;
import com.example.erpConnector.WService.Repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        return webServiceRepository.findAll();
    }

    public List callService (Integer id)
    {
      Optional<WebService> webService ;
      webService= webServiceRepository.findById(id);
      //return extractionServiceRepository.extractData(webService.get().getRow_name(),webService.get().getInputRow(),webService.get().getInputValue());
       Query query=entityManager.createNativeQuery("select first_name from customer  where customer_id=:x");
       String rowName=webService.get().getRow_name();
       String inputvalue=webService.get().getInputValue();
      //  List empNumbers = Arrays.asList("first_name","last_name");
      // System.out.println(rowName);
      query.setParameter("x",inputvalue);


        List author =  query.getResultList();
        System.out.println(author);
        return author ;
        //return extractionServiceRepository.extractData();
        /*Query query = EntityManager.crea*/
        //Query quy="select first_name from customer where customer_id = 1";
        // entityManager.createNativeQuery(  "select id from users where username = ?");
       // entityManager.createNativeQuery("");

    }

    public void  createQuery()
    {
        Query query ;
        query=entityManager.createQuery("");
        query.getSingleResult();
    }

}
