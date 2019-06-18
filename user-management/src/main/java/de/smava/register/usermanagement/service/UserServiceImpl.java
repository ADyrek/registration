package de.smava.register.usermanagement.service;

import de.smava.register.usermanagement.domain.dto.UserDto;
import de.smava.register.usermanagement.domain.entity.UserEntity;
import de.smava.register.usermanagement.mapping.UserMapper;
import de.smava.register.usermanagement.repository.UserRepository;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Data
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Long register(UserDto user) {

        UserEntity userEntity = userMapper.userDtoToUserEntity(user);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));

        final UserEntity entity = userRepository.save(userEntity);

        return entity.getId();
    }

    @Override
    public UserDto findUser(String email) {

        final UserEntity entity = userRepository.findByEmail(email);

        return entity != null ? userMapper.userEntityToUserDto(entity) : null; //TODO make an exception!

    }
}
