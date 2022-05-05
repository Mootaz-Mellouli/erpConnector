package com.example.erpConnector.WService.Controller;

import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Services.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/ws"})
public class WebServiceController {
    @Autowired
    WSService webserviceService ;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping({"/addws"})
    public WebService createWS(@RequestBody WebService webService)
    {
        return webserviceService.addWebService(webService);
    }
}
