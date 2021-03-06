package com.example.erpConnector.WService.Controller;

import com.example.erpConnector.WService.Entity.WebService;
import com.example.erpConnector.WService.Services.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    String urlString ;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({"/callService/{id}"})
    public List mainService(@PathVariable("id")Integer id,HttpServletRequest httpServletRequest)
    {
        this.urlString=httpServletRequest.getRequestURL().toString() ;
        return webserviceService.callService(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({"/geturl"})
    public String getURLValue()
    {
        System.out.println("this is request url : "+urlString);
        return this.urlString ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping({"/delete/{id}"})
    public void deleteService(@PathVariable("id") Integer id)
    {
        webserviceService.deleteService(id);
    }
}
