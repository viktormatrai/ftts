package com.ftts.repository;

import com.ftts.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "race")
public interface RaceRepository extends JpaRepository<Race, Long>  {
    Race getById(@Param("id") Long id);

    @Query(value = "SELECT r from Race r WHERE raceName LIKE %:raceName%")
    Race getByRaceName(@Param("raceName") String raceName);


}
