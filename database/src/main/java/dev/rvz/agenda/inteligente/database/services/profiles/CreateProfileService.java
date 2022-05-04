package dev.rvz.agenda.inteligente.database.services.profiles;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.exceptions.profiles.ProfileWithEmailAlreadyException;
import dev.rvz.agenda.inteligente.database.repositories.ProfileRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.CreateProfileServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.ExistsProfileWithEmailServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileService implements CreateProfileServiceable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateProfileService.class);
	private final ProfileRepository profileRepository;
	private final ExistsProfileWithEmailServiceable existsProfileWithEmailService;

	public CreateProfileService(ProfileRepository profileRepository,
			ExistsProfileWithEmailServiceable existsProfileWithEmailService) {
		this.profileRepository = profileRepository;
		this.existsProfileWithEmailService = existsProfileWithEmailService;
	}

	@Override
	public Profile execute(Profile profile) {
		LOGGER.info("execute - input profile: {} ", profile);
		isExistProfileWithEmail(profile);

		return this.profileRepository.save(profile);
	}

	private void isExistProfileWithEmail(Profile profile) throws ProfileWithEmailAlreadyException {
		String address = profile.getContact().getEmail().getAddress();
		Boolean isExistsProfileWithEmail = this.existsProfileWithEmailService.execute(address);

		if (isExistsProfileWithEmail) {
			LOGGER.error("isExistProfileWithEmail - profile with email " + address + " already!");
			throw new ProfileWithEmailAlreadyException("O Perfil com o email " + address + " ja existe!");
		}
	}

}
