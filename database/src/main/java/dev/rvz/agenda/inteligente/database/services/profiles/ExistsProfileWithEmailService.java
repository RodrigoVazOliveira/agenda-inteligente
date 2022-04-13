package dev.rvz.agenda.inteligente.database.services.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.ExistsProfileWithEmailServiceable;

@Service
public class ExistsProfileWithEmailService implements ExistsProfileWithEmailServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExistsProfileWithEmailService.class);
	private final ProfileRepository profileRepository;

	public ExistsProfileWithEmailService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public Boolean execute(String address) {
		LOGGER.info("execute input address: {}", address);
		Boolean exists = this.profileRepository.existsByContactEmailAddress(address);
		LOGGER.info("execute output exists: {}", exists);

		return exists;
	}

}
