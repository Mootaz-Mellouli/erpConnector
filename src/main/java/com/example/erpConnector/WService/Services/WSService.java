package com.example.erpConnector.WService.Services;

import com.example.erpConnector.WService.Entity.QueryResult;
import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Repository.ExtractionServiceRepository;
import com.example.erpConnector.WService.Repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WSService {

    @Autowired
    WebServiceRepository webServiceRepository ;

    @Autowired
    ExtractionServiceRepository extractionServiceRepository ;

    public WebService addWebService(WebService webService)
    {
        return webServiceRepository.save(webService);
    }

    public List<WebService> getAllWebServices()
    {
        return webServiceRepository.findAll();
    }

    public QueryResult callService (Integer id)
    {
      Optional<WebService> webService ;
      webService= webServiceRepository.findById(id);
      return extractionServiceRepository.extractData(webService.get().getRow_name(),webService.get().getTable_name(),webService.get().getInputRow(),webService.get().getInputValue());
    }

}
