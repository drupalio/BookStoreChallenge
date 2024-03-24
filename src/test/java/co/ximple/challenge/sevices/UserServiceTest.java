package co.ximple.challenge.sevices;

import co.ximple.challenge.mappers.UserMapper;
import co.ximple.challenge.models.UserInformation;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.UserRepository;
import co.ximple.challenge.repository.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserInformation_ValidUser_ReturnUserRecord() {

        UserInformation userInformation = new UserInformation("john@example.com", "password123");
        User user = new User( "John", "Doe", "john@example.com");
        UserRecord expectedUserRecord = new UserRecord(Optional.of(1L), "John", "Doe", "john@example.com");


        when(userRepository.findByEmailAndPassword(userInformation.email(), userInformation.password())).thenReturn(user);
        when(userMapper.entityToRecord(user)).thenReturn(expectedUserRecord);


        UserRecord actualUserRecord = userService.getUserInformation(userInformation);


        assertEquals(expectedUserRecord, actualUserRecord);
    }
}
