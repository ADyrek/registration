package de.smava.registration.persondetails.service;

import de.smava.registration.persondetails.domain.dto.PersonDto;

public interface PersonService {

    boolean saveUserDetails(PersonDto personDto);

    PersonDto retrievePersonDetails(Long userId);
}
