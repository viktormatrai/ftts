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

            teamRepository.save(pavéFixedGearTeam);

            Tag simonTag = Tag.builder().tag("Simon").build();
            tagRepository.save(simonTag);

            List<Tag> tagList = new ArrayList<>();
            tagList.add(simonTag);

            Team bám = Team.builder().teamName("BÁM").build();

            teamRepository.save(bám);

            Race kisoroszi = Race.builder().raceName("Kisoroszi").build();
            Race pilis = Race.builder().raceName("Pilis").build();

            raceRepository.saveAndFlush(kisoroszi);
            raceRepository.saveAndFlush(pilis);

            List<Race> listOfRaces = new ArrayList<>();

            listOfRaces.add(kisoroszi);
            listOfRaces.add(pilis);

            Racer viktor = Racer.builder()
                    .firstName("Viktor")
                    .lastName("Mátrai")
                    .nickName("Viktor")
                    .email("viktor0matrai@gmail.com")
                    .points(20)
                    .gender(Gender.MALE)
                    .races(listOfRaces)
                    .team(pavéFixedGearTeam)
                    .build();

            Racer simon = Racer.builder()
                    .firstName("Simon")
                    .lastName("Mayer")
                    .nickName("Simon")
                    .email("simon.mayer@gmail.com")
                    .races(listOfRaces)
                    .points(20)
                    .gender(Gender.MALE)
                    .team(pavéFixedGearTeam)
                    .build();

            Racer ádi = Racer.builder()
                    .firstName("Ádám")
                    .lastName("Bodansky")
                    .nickName("Ádi")
                    .email("bodanskya@gmail.com")
                    .races(listOfRaces)
                    .points(20)
                    .gender(Gender.MALE)
                    .team(pavéFixedGearTeam)
                    .build();

            Racer levi = Racer.builder()
                    .firstName("Levente")
                    .lastName("Libárdi")
                    .nickName("Levi")
                    .email("levnte.libardi@gmailcom")
                    .team(pavéFixedGearTeam)
                    .points(20)
                    .races(listOfRaces)
                    .gender(Gender.MALE)
                    .build();

            List<Racer> listOfRacersOnRaces = new ArrayList<>();
            listOfRacersOnRaces.add(viktor);
            listOfRacersOnRaces.add(simon);
            listOfRacersOnRaces.add(ádi);
            listOfRacersOnRaces.add(levi);

            List<Racer> listOfRacersInTeam = new ArrayList<>();

            listOfRacersInTeam.add(viktor);
            listOfRacersInTeam.add(simon);
            listOfRacersInTeam.add(ádi);
            listOfRacersInTeam.add(levi);

            pavéFixedGearTeam.setRacers(listOfRacersInTeam);

            pavéFixedGearTeam.calculateTeamPoints(listOfRacersInTeam);

            racerRepository.save(viktor);
            racerRepository.save(simon);
            racerRepository.save(ádi);
            racerRepository.save(levi);

            teamRepository.save(pavéFixedGearTeam);


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
