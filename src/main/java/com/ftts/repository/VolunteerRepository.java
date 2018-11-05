package com.ftts.repository;

import com.ftts.model.Racer;
import com.ftts.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    Volunteer getById(@Param("id") Long id);

    /*@Query(value = "SELECT v FROM Volunteer v WHERE race LIKE %:race%")
    List<Volunteer> getByRace(@Param("race") String race);*/

    @Query(value = "SELECT v FROM Volunteer v WHERE nameOfVolunteer LIKE %:nameOfVolunteer%")
    Racer getByNameOfVolunteer(@Param("nameOfVolunteer") String nameOfVolunteer);

}