package com.ftts.repository;

import com.ftts.model.Gender;
import com.ftts.model.Racer;
import com.ftts.model.Team;
import javafx.scene.canvas.GraphicsContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RacerRepositoryTest {

    @Autowired
    private RacerRepository racerRepository;

    @Test
    public void saveRacer(){
        Racer tesztGyurci = Racer.builder()
                .nameOfRacer("Teszt Gyurci")
                .gender(Gender.MALE)
                .points(14)
                .build();

        racerRepository.save(tesztGyurci);

        List<Racer> racers = racerRepository.findAll();
        assertThat(racers).hasSize(4);
    }

}