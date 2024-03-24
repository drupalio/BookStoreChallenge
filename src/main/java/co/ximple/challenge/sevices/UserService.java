package co.ximple.challenge.sevices;

import co.ximple.challenge.mappers.UserMapper;
import co.ximple.challenge.models.UserInformation;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserRecord getUserInformation(UserInformation user) {
        return userMapper.entityToRecord(userRepository.findByEmailAndPassword(user.email(),user.password()));
    }
}
