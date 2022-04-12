package dev.rvz.agenda.inteligente.database.services.profiles;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.exceptions.ProfileNotFoundException;
import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.FindProfileByEmailServiceable;

@Service
public class FindProfileByEmailService implements FindProfileByEmailServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(FindProfileByEmailService.class);
	private final ProfileRepository profileRepository;

	public FindProfileByEmailService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Transactional
	@Override
	public Profile execute(String email) {
		LOGGER.info("execute - input email: {}", email);
		Profile profile = findByEmail(email);
		LOGGER.info("execute - output profile: {}", profile);

		return profile;
	}

	private Profile findByEmail(String email) {
		LOGGER.info("findByEmail - iniciando busca do perfil por email");
		Optional<Profile> profileOptinal = this.profileRepository.findByContactEmailAddress(email);
		isEmptyFindByEmail(email, profileOptinal);

		return profileOptinal.get();
	}

	private void isEmptyFindByEmail(String email, Optional<Profile> profileOptinal) {
		LOGGER.info("isEmptyFindByEmail - verificar se a busca esta vazia");
		if (profileOptinal.isEmpty()) {
			LOGGER.error("isEmptyFindByEmail - perfil nao encontrado");
			throw new ProfileNotFoundException("Perfil nao encontrado com email " + email);
		}
	}

}
