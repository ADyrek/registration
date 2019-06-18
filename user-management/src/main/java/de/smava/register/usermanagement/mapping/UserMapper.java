package de.smava.register.usermanagement.mapping;

import de.smava.register.usermanagement.domain.dto.UserDto;
import de.smava.register.usermanagement.domain.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserEntity userDtoToUserEntity(UserDto userDto);

    UserDto userEntityToUserDto(UserEntity entity);
}
