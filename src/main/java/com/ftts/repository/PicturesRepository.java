package com.ftts.repository;


import com.ftts.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource(path = "pictures")
public interface PicturesRepository extends JpaRepository<Pictures, Long> {


    @Query(value = "SELECT p FROM pictiures p WHERE tag LIKE %:tag%")
    List<Pictures> getPictureByTags(@PathVariable("tag") String tag);
}
