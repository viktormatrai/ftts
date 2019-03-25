package com.ftts.repository;

import com.ftts.model.Race;
import com.ftts.model.Racer;
import com.ftts.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tag")
public interface TagRepository extends JpaRepository<Tag, Long> {


    Tag getByTag(@Param("tag") String tag);

    //Tag getByRace(@Param("race")Race race);

    //Tag getByRacer(@Param("racer") Racer racer);
}
