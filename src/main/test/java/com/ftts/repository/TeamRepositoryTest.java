package com.ftts.repository;

import com.ftts.model.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void saveTeam(){
        Team testTeam = Team.builder().teamName("test team").build();


        teamRepository.save(testTeam);

        List<Team> teams= teamRepository.findAll();

        assertThat(teams).hasSize(3);
    }
}
