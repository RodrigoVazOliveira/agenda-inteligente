package dev.rvz.agenda.inteligente.database.controllers.contract;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.database.dtos.CreateProfileDTO;
import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface ProfileRestControllerable {

	Profile create(@RequestBody CreateProfileDTO createProfileDTO);

	Iterable<Profile> getAll();

	Profile getById(@PathVariable Long id);
}
