package com.application.demo_etax_invoice;

import com.application.demo_etax_invoice.entity.User;
import com.application.demo_etax_invoice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest // Use @SpringBootTest if you need to load the full application context
@ActiveProfiles("test") // Optional: Use a separate profile for testing
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
    interface UserInfo{
        String name = "John";
        String email = "test@example.com";
    }
}
