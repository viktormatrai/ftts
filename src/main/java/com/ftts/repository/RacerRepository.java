package com.ftts.repository;

import com.ftts.model.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "racer")
public interface RacerRepository extends JpaRepository<Racer, Long> {

    Racer getById(@Param("id") Long id);


  /*  @Query(value = "SELECT r FROM Racer r WHERE firstName LIKE %:firstName% ORDER BY id")
    List<Racer>findAllByFirstName(@Param("firstName") String firstName);

    @Query(value = "SELECT r FROM Racer r WHERE gender LIKE %:gender% ORDER BY firstName")
    List<Racer>findAllByGender(@Param("gender") String gender);
    */

}


