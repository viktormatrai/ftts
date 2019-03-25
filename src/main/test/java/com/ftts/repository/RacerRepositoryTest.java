package com.ftts.repository;

import antlr.build.Tool;
import com.ftts.model.Gender;
import com.ftts.model.Racer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RacerRepositoryTest {

    @Autowired
    private RacerRepository racerRepository;


    @Test
    public void iffSavesRacer(){
        Racer tesztGyurci = Racer.builder()
                .nickName("Teszt Gyurci")
                .firstName("Teszt")
                .lastName("György")
                .email("teszt.györgy@test.com")
                .gender(Gender.MALE)
                .points(5)
                .build();

        racerRepository.save(tesztGyurci);

        List<Racer> racers = racerRepository.findAll();
        assertThat(racers).hasSize(5);
    }

}