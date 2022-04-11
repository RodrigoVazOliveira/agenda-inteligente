package dev.rvz.agenda.inteligente.database.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
