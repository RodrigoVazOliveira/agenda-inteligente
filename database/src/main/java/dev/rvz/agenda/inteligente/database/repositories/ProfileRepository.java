package dev.rvz.agenda.inteligente.database.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

	Optional<Profile> findByContactEmailAddress(String email);

	Boolean existsByContactEmailAddress(String address);
}
