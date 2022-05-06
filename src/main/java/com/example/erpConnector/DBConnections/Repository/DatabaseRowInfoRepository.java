package com.example.erpConnector.DBConnections.Repository;

import com.example.erpConnector.DBConnections.Entities.DatabaseRowInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseRowInfoRepository extends JpaRepository<DatabaseRowInfo,String> {


    @Query(value = "select column_name as column_name , data_type as data_type from information_schema.columns where table_name = :tableName " +
            " and table_schema = :dbName  order by ordinal_position;", nativeQuery = true)
    List<DatabaseRowInfo> getDataBaseRowInfo(@Param("tableName") String tableName,@Param("dbName") String dbName) ;

}
