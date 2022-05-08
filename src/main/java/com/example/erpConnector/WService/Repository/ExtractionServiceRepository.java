package com.example.erpConnector.WService.Repository;

import com.example.erpConnector.WService.Entity.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface ExtractionServiceRepository extends JpaRepository<QueryResult,String> {

/*
    @Query(value = "select :rowName from customer where :inputRow = :inputValue", nativeQuery = true)
*/
  // QueryResult extractData(@Param("rowName") String rowName, @Param("inputRow") String inputRow , @Param("inputValue") String inputValue) ;
    @Query(value = "select first_name from customer where customer_id = 1", nativeQuery = true)
    QueryResult extractData() ;




}
