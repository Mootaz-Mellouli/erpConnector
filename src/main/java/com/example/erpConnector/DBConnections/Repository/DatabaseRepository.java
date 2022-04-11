package com.example.erpConnector.DBConnections.Repository;

import com.example.erpConnector.DBConnections.Entities.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<Database,Integer> {
}
