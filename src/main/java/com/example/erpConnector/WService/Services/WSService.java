package com.example.erpConnector.WService.Services;

import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WSService {

    @Autowired
    WebServiceRepository webServiceRepository ;

    public WebService addWebService(WebService webService)
    {
        return webServiceRepository.save(webService);
    }

}
