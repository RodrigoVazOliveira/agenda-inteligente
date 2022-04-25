package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.profiles.CreateProfileBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.profiles.CreateProfileInternalErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.ProfileDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateProfileServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class CreateProfileService implements CreateProfileServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateProfileService.class);
	private final ProfileDatabase profileDatabase;

	public CreateProfileService(ProfileDatabase profileDatabase) {
		this.profileDatabase = profileDatabase;
	}

	@Override
	public ProfileResponseDTO run(CreateProfileRequestDTO createProfileRequestDTO) {
		return create(createProfileRequestDTO);
	}

	private ProfileResponseDTO create(CreateProfileRequestDTO createProfileRequestDTO) {
		LOGGER.info("create - initial create profile");
		try {
			return requestCreateProfile(createProfileRequestDTO);
		} catch (FeignClientException exception) {
			isErrorCreateProfile(exception);
			return null;
		} catch (FeignException exception) {
			LOGGER.error("create - status : {}, message : {}", exception.status(), exception.getMessage());
			throw new CreateProfileInternalErrorException(exception.getMessage());
		}
	}

	private ProfileResponseDTO requestCreateProfile(CreateProfileRequestDTO createProfileRequestDTO) {
		LOGGER.info("requestCreateProfile - createProfileRequestDTO : {}", createProfileRequestDTO);
		ProfileResponseDTO profileResponseDTO = this.profileDatabase.create(createProfileRequestDTO);
		LOGGER.info("requestCreateProfile - profileResponseDTO : {}", profileResponseDTO);

		return profileResponseDTO;
	}

	private void isErrorCreateProfile(FeignClientException exception) {
		LOGGER.error("isErrorCreateProfile - status : {}, message: {}", exception.status(), exception.getMessage());

		if (exception.status() == 400) {
			throw new CreateProfileBadRequestException(exception.getMessage());
		}

		throw new CreateProfileInternalErrorException(exception.getMessage());
	}

}
