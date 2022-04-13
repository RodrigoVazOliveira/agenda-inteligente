package dev.rvz.agenda.inteligente.database.services.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.GetAllProfilesServiceable;

@Service
public class GetAllProfilesService implements GetAllProfilesServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetAllProfilesService.class);
	private final ProfileRepository profileRepository;

	public GetAllProfilesService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Transactional
	@Override
	public Iterable<Profile> execute() {
		Iterable<Profile> profiles = this.profileRepository.findAll();
		LOGGER.info("execute - outpout profiles: {}", profiles);

		return profiles;
	}

}
