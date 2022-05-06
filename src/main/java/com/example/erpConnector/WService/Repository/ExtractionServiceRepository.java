package com.example.erpConnector.WService.Repository;

import com.example.erpConnector.WService.Entity.QueryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtractionServiceRepository extends JpaRepository<QueryResult,String> {

    @Query(value = "select :rowName from :tableName where :inputRow = :inputValue order by 1;", nativeQuery = true)
    QueryResult extractData(@Param("rowName") String rowName, @Param("tableName") String tableName, @Param("inputRow") String inputRow , @Param("inputValue") String inputValue) ;
}
