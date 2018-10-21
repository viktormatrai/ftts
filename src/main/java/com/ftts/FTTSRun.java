package com.ftts;

import com.ftts.model.Race;
import com.ftts.model.Racer;
import com.ftts.model.Team;
import com.ftts.repository.RacerRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(FTTSRun.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Team pavéFixedGearTeam = Team.builder().
                    teamName("Pavé Fixed Gear Team").build();

            teamRepository.save(pavéFixedGearTeam);

            Racer viktor = Racer.builder().name("Viktor").points(20).team(pavéFixedGearTeam).build();
            Racer simon = Racer.builder().name("Simon").points(20).team(pavéFixedGearTeam).build();

            racerRepository.save(viktor);
            racerRepository.save(simon);
        };
    }



}
