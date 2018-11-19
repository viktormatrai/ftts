package com.ftts.repository;

import com.ftts.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "team")
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team getById(@Param("id") Long id);

    /*@Query(value = "SELECT t FROM Team t WHERE teamName LIKE %teamName% ORDER BY id")
    Team getTeamByTeamName(@Param("teamName") String teamName);*/
}
