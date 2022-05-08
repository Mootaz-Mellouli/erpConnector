package com.example.erpConnector.WService.Controller;

import com.example.erpConnector.WService.Entity.QueryResult;
import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Services.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({"/"})
    public List<WebService> getAllWSCreated()
    {
        return webserviceService.getAllWebServices();
    }

    /*@GetMapping({"/{id}"})
    public Optional<WebService> getservicebyID(@PathVariable("id") Integer id)
    {
     return webserviceService.callService(id);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({"/{id}"})
    public List mainService(@PathVariable("id")Integer id)
    {

         return webserviceService.callService(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping({"/delete/{id}"})
    public void deleteService(@PathVariable("id") Integer id)
    {
        webserviceService.deleteService(id);
    }
}
