package de.smava.registration.persondetails.service;

import de.smava.registration.persondetails.domain.dto.PersonDto;
import de.smava.registration.persondetails.domain.entity.PersonEntity;
import de.smava.registration.persondetails.mapping.PersonMapper;
import de.smava.registration.persondetails.repository.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Data
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    @Transactional
    public boolean saveUserDetails(PersonDto personDto) {

        final PersonEntity entity = personMapper.personDtoToPersonEntity(personDto);
        return personRepository.save(entity) != null;
    }

    @Override
    public PersonDto retrievePersonDetails(Long userId) {

        final PersonEntity entity = personRepository.findByUserId(userId);

        return entity != null ? personMapper.personEntityToPersonDto(entity) : null; //TODO exception + ControllerAdvice
    }
}
