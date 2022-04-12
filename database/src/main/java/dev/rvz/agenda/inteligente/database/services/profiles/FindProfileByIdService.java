package dev.rvz.agenda.inteligente.database.services.profiles;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.exceptions.ProfileNotFoundException;
import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.FindProfileByIdServiceable;

@Service
public class FindProfileByIdService implements FindProfileByIdServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(FindProfileByIdService.class);
	private final ProfileRepository profileRepository;

	public FindProfileByIdService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public Profile execute(Long id) {
		LOGGER.info("execute - input id: {}", id);
		Optional<Profile> profileOptional = this.profileRepository.findById(id);
		isEmptyFindByIdProfile(id, profileOptional);

		return profileOptional.get();
	}

	private void isEmptyFindByIdProfile(Long id, Optional<Profile> profileOptional) throws ProfileNotFoundException {
		LOGGER.info("isEmptyFindByIdProfile - profileOptional: {}", profileOptional);
		if (profileOptional.isEmpty()) {
			LOGGER.error("isEmptyFindByIdProfile - profile not found with id {}", id);
			throw new ProfileNotFoundException("nao foi localizado um pefil com id " + id);
		}
	}
}
