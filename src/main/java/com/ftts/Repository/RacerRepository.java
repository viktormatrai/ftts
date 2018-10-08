package com.ftts.Repository;

import com.ftts.data.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.awt.print.Pageable;
import java.util.List;

@RestResource(path = "racer")
public interface RacerRepository extends JpaRepository<Racer, Integer> {

    Racer getById(@Param("id") Integer id);

    @Query(value = "SELECT r FROM Racer r WHERE firstName LIKE %:query% ORDER BY id")
    List<Racer>findAllByFirstName(@Param("query") String query, Pageable pageable);

}
