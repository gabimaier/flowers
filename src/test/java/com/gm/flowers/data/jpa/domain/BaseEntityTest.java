package com.gm.flowers.data.jpa.domain;

import com.gm.flowers.Application;
import com.gm.flowers.data.jpa.service.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BaseEntityTest {
    private static final String TEST_USERNAME = "aaa";

    @Inject
    private UserRepository userRepository;
    private LocalDateTime preInsertTime, postInsertTime;

    @Before
    public void setup() throws InterruptedException {
        if(preInsertTime==null) {
            cleanup();
            User user = new User();
            user.setUsername(TEST_USERNAME);
            preInsertTime = LocalDateTime.now();
            userRepository.save(user);
            postInsertTime = LocalDateTime.now();
        }
    }

    @After
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    public void should_default_fields_when_inserting(){
        //given
        //when
        User foundUser =  userRepository.findByUsername(TEST_USERNAME);
        //then
        assertThat(foundUser.getId(), not(isEmptyOrNullString()));
        assertThat(UUID.fromString(foundUser.getId()), notNullValue());
    }

    @Test
    public void should_set_last_updated_timestamp_when_inserting(){
        //given
        //when
        User foundUser =  userRepository.findByUsername(TEST_USERNAME);
        //then
        LocalDateTime lastUpdated = foundUser.getLastUpdated();
        assertThat(lastUpdated, notNullValue());
        assertThat(String.format("lastUpdated=%s preInsertTime=%s", lastUpdated, preInsertTime), !lastUpdated.isBefore(preInsertTime), is(true));
        assertThat(String.format("lastUpdated=%s postInsertTime=%s", lastUpdated, postInsertTime), !lastUpdated.isAfter(postInsertTime), is(true));

    }

    @Test
    public void should_set_last_updated_timestamp_when_updating() throws InterruptedException {
        //given
        User user =  userRepository.findByUsername(TEST_USERNAME);
        user.setUsername(TEST_USERNAME + 1);
        userRepository.save(user);
        user.setUsername(TEST_USERNAME);
        final LocalDateTime preUpdateTime = LocalDateTime.now();
        //when
        userRepository.save(user);
        final LocalDateTime postUpdateTime = LocalDateTime.now();
        User foundUser =  userRepository.findOne(user.getId());
        //then
        final LocalDateTime lastUpdated = foundUser.getLastUpdated();
        assertThat(lastUpdated, notNullValue());
        assertThat(String.format("lastUpdated=%s preUpdateTime=%s", lastUpdated, preUpdateTime),
                lastUpdated.isAfter(preUpdateTime), is(true));
        assertThat(String.format("lastUpdated=%s postUpdateTime=%s", lastUpdated, postUpdateTime),
                lastUpdated.isBefore(postUpdateTime), is(true));
    }

}