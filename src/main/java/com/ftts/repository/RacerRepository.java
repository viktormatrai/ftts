package com.ftts.repository;

import com.ftts.model.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource(path = "racer")
public interface RacerRepository extends JpaRepository<Racer, Long> {

    Racer getById(@Param("id") Long id);


    @Query(value = "SELECT r FROM Racer r WHERE name LIKE %:nameOfRacer%")
    Racer getByNameOfRacer(@Param("nameOfRacer") String nameOfRacer);

    @Query(value = "SELECT r FROM Racer r WHERE gender LIKE %:gender% ORDER BY name")
    List<Racer>getAllByGender(@Param("gender") String gender);


}


