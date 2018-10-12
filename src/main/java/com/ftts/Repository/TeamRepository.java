package com.ftts.Repository;

import com.ftts.data.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "team")
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team getById(@Param("id") Integer id);

    @Query(value = "SELECT t FROM Team t WHERE teamName LIKE %teamName% ORDER BY id")
    List<Team>findTeamByTeamName(@Param("teamName") String teamName);
}
