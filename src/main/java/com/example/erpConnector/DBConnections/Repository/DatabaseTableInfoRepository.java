package com.example.erpConnector.DBConnections.Repository;

import com.example.erpConnector.DBConnections.Entities.DatabaseTableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DatabaseTableInfoRepository extends JpaRepository<DatabaseTableInfo,String> {

    /*@Query(value = "select tab.table_schema as database_schema,tab.table_name as table_name," +
            "col.ordinal_position as column_id,col.column_name as column_name,col.data_type as data_type from information_schema.tables " +
            " as tab inner join information_schema.columns as col on col.table_schema = tab.table_schema " +
            "and col.table_name = tab.table_name where tab.table_type = 'BASE TABLE' and tab.table_schema not in ('information_schema','mysql'," +
            "'performance_schema','sys') and tab.table_schema = :x  ",nativeQuery = true)*/
    @Query(value = "select table_schema as database_name, table_name from information_schema.tables where table_type = 'BASE TABLE'" +
            "  and table_schema = :x order by database_name, table_name;", nativeQuery = true)
    List<DatabaseTableInfo> getDataBaseTableInfo(@Param("x") String x) ;

//'customer'
}
