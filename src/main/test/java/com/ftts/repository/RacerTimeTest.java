package com.ftts.repository;

import com.ftts.model.Race;
import com.ftts.model.Racer;
import com.ftts.model.RacerTime;
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
public class RacerTimeTest {


    @Test
    public void calculateFinalTime() {
        RacerTime racerTime = new RacerTime();

        LocalTime startingTime = LocalTime.of(11,11,11);
        LocalTime finishingTime = LocalTime.of(11, 21, 11);
        Long neutral1 = Long.valueOf(5);
        Long neutral2 = Long.valueOf(5);
        Long neutral3 = Long.valueOf(1);
        
        racerTime.calculateFinalTime(startingTime, finishingTime, neutral1, neutral2, neutral3);
        LocalTime expectedFinishingTime = LocalTime.of(00,9,49);
        assertThat(racerTime.getFinalTime()).isEqualToIgnoringNanos(expectedFinishingTime);
    }

    @Test
    public void setStartingTime() {
        RacerTime racerTime = new RacerTime();
        racerTime.setStartingTime(LocalTime.of(11,11,11));
        assertThat(racerTime.getStartingTime()).hasSameHourAs(LocalTime.of(11,11,11));
    }

    @Test
    public void setFinishingTime() {
        RacerTime racerTime = new RacerTime();
        racerTime.setFinishingTime(LocalTime.of(12,12,12));
        assertThat(racerTime.getFinishingTime()).hasSameHourAs(LocalTime.of(12,12,12));
    }

    @Test
    public void setNeutralZoneOne() {
        RacerTime racerTime = new RacerTime();
        racerTime.setNeutralZoneOne((long) 2);
        assertThat(racerTime.getNeutralZoneOne()).isEqualTo(2);
    }

    @Test
    public void setNeutralZoneTwo() {
        RacerTime racerTime = new RacerTime();
        racerTime.setNeutralZoneTwo((long) 2);
        assertThat(racerTime.getNeutralZoneTwo()).isEqualTo(2);
    }

    @Test
    public void setNeutralZoneThree() {
        RacerTime racerTime = new RacerTime();
        racerTime.setNeutralZoneThree((long) 2);
        assertThat(racerTime.getNeutralZoneThree()).isEqualTo(2);
    }

}
