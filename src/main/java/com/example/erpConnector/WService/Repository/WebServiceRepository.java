package com.example.erpConnector.WService.Repository;

import com.example.erpConnector.WService.Entity.WebService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebServiceRepository extends JpaRepository<WebService,Integer> {
}
