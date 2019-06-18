package de.smava.registration.persondetails.controller;

import de.smava.registration.persondetails.domain.dto.PersonDto;
import de.smava.registration.persondetails.domain.dto.PersonResponse;
import de.smava.registration.persondetails.service.PersonService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/personDetails/{userId}")
    public PersonDto retrievePersonDetails(@PathVariable("userId") Long userId) {
        return personService.retrievePersonDetails(userId);
    }


    @PostMapping("/personDetails")
    public PersonResponse saveUserDetails(@RequestBody PersonDto personDto) {

        return PersonResponse
                .builder()
                .success(personService.saveUserDetails(personDto))
                .build();
    }

}
