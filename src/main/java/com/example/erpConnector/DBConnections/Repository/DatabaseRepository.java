package com.example.erpConnector.DBConnections.Repository;

import com.example.erpConnector.DBConnections.Entities.DatabaseConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatabaseRepository extends JpaRepository<DatabaseConnection,Integer> {

DatabaseConnection findDatabaseConnectionByDbID(Integer id);


DatabaseConnection findDatabaseConnectionByDbname(String name);

}
