package com.ftts.Repository;

import com.ftts.data.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "race")
public interface RaceRepository extends JpaRepository<Race, Integer>  {
    Race getById(@Param("id") Integer id);

    @Query(value = "SELECT r from Race r WHERE raceName LIKE %:raceName%")
    Race getByRaceName(@Param("raceName") String raceName);
}
