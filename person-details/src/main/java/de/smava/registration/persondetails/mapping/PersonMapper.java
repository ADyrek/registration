package de.smava.registration.persondetails.mapping;


import de.smava.registration.persondetails.domain.dto.PersonDto;
import de.smava.registration.persondetails.domain.entity.PersonEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface PersonMapper {

    PersonEntity personDtoToPersonEntity(PersonDto userDto);

    PersonDto personEntityToPersonDto(PersonEntity entity);
}
