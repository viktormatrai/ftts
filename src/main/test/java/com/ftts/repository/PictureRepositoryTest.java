package com.ftts.repository;

import com.ftts.model.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PictureRepositoryTest {

    @Autowired
    PictureRepository pictureRepository;

    @Test
    public void savePicture(){
        Picture sample = Picture.builder()
                .pictureURL("https://drive.google.com/file/d/177LLI1JQB5r9xQpUblVSTQgnCs6UjuS2/view?usp=sharing")
                .build();

        pictureRepository.save(sample);

        List<Picture> pictureList = pictureRepository.findAll();
        assertThat(pictureList).hasSize(2);
    }


}
