package com.ftts.repository;

import com.ftts.model.Race;
import org.assertj.core.api.AbstractLocalTimeAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RaceRepositoryTest {


    @Test
    public void calculateFinalTime() {
        Race testRace = new Race();

        LocalTime startingTime = LocalTime.of(11,11,11);
        LocalTime finishingTime = LocalTime.of(11, 21, 11);
        Long neutral1 = Long.valueOf(5);
        Long neutral2 = Long.valueOf(5);
        Long neutral3 = Long.valueOf(1);
        
        testRace.calculateFinalTime(startingTime, finishingTime, neutral1, neutral2, neutral3);
        
        LocalTime expectedFinishingTime = LocalTime.of(00,9,49);
        assertThat(testRace.getFinalTime()).isEqualToIgnoringNanos(expectedFinishingTime);

    }

    @Test
    public void setStartingTime() {
        Race testRace = new Race();

        testRace.setStartingTime(LocalTime.of(11,11,11));

        assertThat(testRace.getStartingTime()).hasSameHourAs(LocalTime.of(11,11,11));
    }

    @Test
    public void setFinishingTime() {

        Race testRace = new Race();

        testRace.setFinishingTime(LocalTime.of(12,12,12));

        assertThat(testRace.getFinishingTime()).hasSameHourAs(LocalTime.of(12,12,12));
    }

    @Test
    public void setNeutralZoneOne() {

        Race testRace = new Race();

        testRace.setNeutralZoneOne((long) 2);

        assertThat(testRace.getNeutralZoneOne()).isEqualTo(2);
    }

    @Test
    public void setNeutralZoneTwo() {
        Race testRace = new Race();

        testRace.setNeutralZoneTwo((long) 2);

        assertThat(testRace.getNeutralZoneTwo()).isEqualTo(2);
    }

    @Test
    public void setNeutralZoneThree() {
        Race testRace = new Race();

        testRace.setNeutralZoneThree((long) 2);

        assertThat(testRace.getNeutralZoneThree()).isEqualTo(2);
    }


}
