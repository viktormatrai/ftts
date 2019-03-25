package com.ftts.repository;


import com.ftts.model.Picture;
import com.ftts.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource(path = "picture")
public interface PictureRepository extends JpaRepository<Picture, Long> {


  //  @Query(value = "SELECT p FROM picture p WHERE tag LIKE %:tag%")
  //  List<Picture> getPicturesByTag(@PathVariable("tag") Tag tag);
}
