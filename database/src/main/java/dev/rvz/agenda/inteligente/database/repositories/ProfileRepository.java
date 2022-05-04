package dev.rvz.agenda.inteligente.database.repositories;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

	Optional<Profile> findByContactEmailAddress(String email);

	Boolean existsByContactEmailAddress(String address);
}
