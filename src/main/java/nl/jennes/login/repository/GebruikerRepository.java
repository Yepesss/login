package nl.jennes.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.jennes.login.Gebruiker;


@Component
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {

}

