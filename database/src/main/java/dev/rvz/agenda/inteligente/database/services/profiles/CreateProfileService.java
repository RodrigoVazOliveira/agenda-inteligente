package dev.rvz.agenda.inteligente.database.services.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.CreateProfileServiceable;

@Service
public class CreateProfileService implements CreateProfileServiceable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateProfileService.class);
	private final ProfileRepository profileRepository;

	public CreateProfileService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public Profile execute(Profile profile) {
		LOGGER.info("execute - input profile: {} ", profile);
		return this.profileRepository.save(profile);
	}

}
