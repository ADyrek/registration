package de.smava.registration.persondetails.repository;


import de.smava.registration.persondetails.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByUserId(Long userId);

}
