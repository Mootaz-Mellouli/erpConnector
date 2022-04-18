package com.example.erpConnector.WService.Controller;

import com.example.erpConnector.WService.Configurations.DataSourceContexHolder;
import com.example.erpConnector.WService.Configurations.DataSourceEnum;
import com.example.erpConnector.WService.Entity.Customer;
import com.example.erpConnector.WService.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    CustomerService customerService ;


    private final DataSourceContexHolder dataSourceContexHolder ;

    @GetMapping(path = "/customers/{dataSourceType}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getallCustomers(@PathVariable("dataSourceType") String dataSourceType)
    {
        if(dataSourceType.equals("ONE"))
        {
            dataSourceContexHolder.setBranchContext(DataSourceEnum.DataSourceONE);
        }else if(dataSourceType.equals("TWO")) {
            dataSourceContexHolder.setBranchContext(DataSourceEnum.DataSourceTWO);
        }else {
            throw new RuntimeException("No Such DataBase");
        }
        return customerService.getCustomers();
    }
}
