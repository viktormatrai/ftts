package com.ftts.repository;

import com.ftts.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "volunteer")
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    Volunteer getById(@Param("id") Long id);

    /*@Query(value = "SELECT v FROM Volunteer v WHERE race LIKE %:race%")
    List<Volunteer> getByRace(@Param("race") String race);*/

    @Query(value = "SELECT v FROM Volunteer v WHERE nameOfVolunteer LIKE %:nameOfVolunteer%")
    Volunteer getByNameOfVolunteer(@Param("nameOfVolunteer") String nameOfVolunteer);

}
