package com.ftts;

import com.ftts.model.*;
import com.ftts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class FTTSRun {

    @Autowired
    RacerRepository racerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Autowired
    PictureRepository pictureRepository;

    public static void main(String[] args) {
        SpringApplication.run(FTTSRun.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner init(){

        return args -> {
            Team pavéFixedGearTeam = Team.builder().
                    teamName("Pavé Fixed Gear Team").build();

            Tag simonTag = Tag.builder().tag("Simon").build();
            tagRepository.save(simonTag);

            List<Tag> tagList = new ArrayList<>();
            tagList.add(simonTag);

            teamRepository.save(pavéFixedGearTeam);

            Team bám = Team.builder().teamName("BÁM").build();

            teamRepository.save(bám);

            Race kisoroszi = Race.builder().raceName("Kisoroszi").build();
            Race pilis = Race.builder().raceName("Pilis").build();

            raceRepository.saveAndFlush(kisoroszi);
            raceRepository.saveAndFlush(pilis);

            List<Race> listOfRaces = new ArrayList<>();

            listOfRaces.add(kisoroszi);
            listOfRaces.add(pilis);

            Racer viktor = Racer.builder().nameOfRacer("Viktor").points(20)
                    .gender(Gender.MALE).races(listOfRaces).team(pavéFixedGearTeam).build();
            Racer simon = Racer.builder().nameOfRacer("Simon").races(listOfRaces).tag(tagList).points(20)
                    .gender(Gender.MALE).team(pavéFixedGearTeam).build();
            Racer ádi = Racer.builder().nameOfRacer("Ádi").races(listOfRaces).points(20)
                    .gender(Gender.MALE).team(pavéFixedGearTeam).build();

            List<Racer> listOfRacersOnRaces = new ArrayList<>();
            listOfRacersOnRaces.add(viktor);
            listOfRacersOnRaces.add(simon);
            listOfRacersOnRaces.add(ádi);
            kisoroszi.setRacers(listOfRacersOnRaces);

            List<Racer> listOfRacersInTeam = new ArrayList<>();

            listOfRacersInTeam.add(viktor);
            listOfRacersInTeam.add(simon);
            listOfRacersInTeam.add(ádi);

            pavéFixedGearTeam.setRacers(listOfRacersInTeam);

            racerRepository.save(viktor);
            racerRepository.save(simon);
            racerRepository.save(ádi);




            Volunteer segitoKedves = Volunteer.builder().nameOfVolunteer("kedves")
                    .firstName("Segítő").lastName("Kedves").email("segito@segit.hu").build();
            Volunteer segitoGeza = Volunteer.builder().nameOfVolunteer("Geza")
                    .firstName("Stopper").lastName("Géza").email("geza@segit.hu").races(listOfRaces).build();

            List<Volunteer> listOfVolunteersOnRaces = new ArrayList<>();
            listOfVolunteersOnRaces.add(segitoGeza);

            volunteerRepository.save(segitoKedves);
            volunteerRepository.save(segitoGeza);

            String samplePicture = "https://drive.google.com/file/d/177LLI1JQB5r9xQpUblVSTQgnCs6UjuS2/view?usp=sharing";
            Picture pictureSample = Picture.builder().pictureURL(samplePicture).build();

            pictureRepository.save(pictureSample);
        };
    }



}
