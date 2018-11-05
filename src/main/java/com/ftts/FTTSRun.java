package com.ftts;

import com.ftts.model.*;
import com.ftts.repository.RaceRepository;
import com.ftts.repository.RacerRepository;
import com.ftts.repository.TagRepository;
import com.ftts.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




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

    public static void main(String[] args) {
        SpringApplication.run(FTTSRun.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Team pavéFixedGearTeam = Team.builder().
                    teamName("Pavé Fixed Gear Team").build();


            teamRepository.save(pavéFixedGearTeam);

            Team bám = Team.builder().teamName("BÁM").build();

            teamRepository.save(bám);





            Racer viktor = Racer.builder().nameOfRacer("Viktor").points(20)
                    .gender(Gender.MALE).build();
            Racer simon = Racer.builder().nameOfRacer("Simon").points(20)
                    .gender(Gender.MALE).build();
            Racer ádi = Racer.builder().nameOfRacer("Ádi").points(20)
                    .gender(Gender.MALE).build();

            racerRepository.save(viktor);
            racerRepository.save(simon);
            racerRepository.save(ádi);


            Race kisoroszi = Race.builder().raceName("Kisoroszi").build();
            Race pilis = Race.builder().raceName("Pilis").build();

            raceRepository.save(kisoroszi);
            raceRepository.save(pilis);

            Tag simonTag = Tag.builder().tag("Simon").build();
            tagRepository.save(simonTag);

        };
    }



}
