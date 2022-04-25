package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.profiles.CreateProfileBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.profiles.GetAllProfileInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.ProfileDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetByIdProfileServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class GetByIdProfileService implements GetByIdProfileServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetByIdProfileService.class);
	private final ProfileDatabase profileDatabase;

	public GetByIdProfileService(ProfileDatabase profileDatabase) {
		this.profileDatabase = profileDatabase;
	}

	@Override
	public ProfileResponseDTO run(Long id) {
		try {
			return request(id);
		} catch (FeignClientException exception) {
			getByIdError(exception);
			return null;
		} catch (FeignException exception) {
			throw new GetAllProfileInternalServerErrorException(exception.getMessage());
		}
	}

	private void getByIdError(FeignClientException exception) {
		LOGGER.error("getByIdError - status: {}, message: {}", exception.status(), exception.getMessage());
		if (exception.status() == 400) {
			throw new CreateProfileBadRequestException(exception.getMessage());
		}

		throw new GetAllProfileInternalServerErrorException(exception.getMessage());
	}

	private ProfileResponseDTO request(Long id) {
		LOGGER.info("request - id : {}", id);
		ProfileResponseDTO profileResponseDTO = this.profileDatabase.getById(id);
		LOGGER.info("request - profileResponseDTO : {}", profileResponseDTO);

		return profileResponseDTO;
	}

}
