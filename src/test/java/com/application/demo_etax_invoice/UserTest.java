package com.application.demo_etax_invoice;

import com.application.demo_etax_invoice.entity.User;
import com.application.demo_etax_invoice.entity.UserVerify;
import com.application.demo_etax_invoice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserEntity() {
        User user = User.builder()
                .email(UserInfo.email)
                .build();
        assertEquals(UserInfo.email, user.getEmail());
    }

    @Test
    public void testUserRepository() {
        User user = User.builder()
                .email(UserInfo.email)
                .build();
        userRepository.save(user);
        User foundUser = userRepository.findById(UserInfo.email).orElseThrow();
        assertEquals(UserInfo.email, foundUser.getEmail());
    }

    @Test
    public void testUserRepositoryDelete() {
        User user = User.builder()
                .email(UserInfo.email)
                .build();
        userRepository.save(user);
        userRepository.deleteById(UserInfo.email);
        assertEquals(0, userRepository.count());
    }
    @Test
    public void testUserVerifyEntity() {
        User user = User.builder()
                .email(UserInfo.email)
                .build();
        UserVerify userVerify = UserVerify.builder()
                .user(user)
                .build();
        assertEquals(user, userVerify.getUser());
    }
    interface UserInfo {
        String name = "John";
        String email = "test@example.com";
    }
}
