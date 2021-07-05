package com.lucifer.expensemanager;

import com.lucifer.expensemanager.entity.User;
import com.lucifer.expensemanager.repository.UserRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    public void createUser(){
        User user = new User("Gyana Mohanty",5106);
        userRepository.saveAndFlush(user);
        assertEquals(1,userRepository.count());
    }

    @Test
    public void findUser(){
        User user = userRepository.findByName("Gyana Mohanty");
        assertNotNull(user);
        assertEquals("Gyana Mohanty",user.getName());
    }
}
