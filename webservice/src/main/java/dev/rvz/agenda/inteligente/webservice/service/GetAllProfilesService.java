package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.profiles.GetAllProfileInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.ProfileDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllProfilesServicePort;
import feign.FeignException;

@Service
public class GetAllProfilesService implements GetAllProfilesServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetAllProfilesService.class);
	private final ProfileDatabase profileDatabase;

	public GetAllProfilesService(ProfileDatabase profileDatabase) {
		this.profileDatabase = profileDatabase;
	}

	@Override
	public Iterable<ProfileResponseDTO> run() {
		try {
			return request();
		} catch (FeignException exception) {
			LOGGER.error("rn - status: {}, message: {}", exception.status(), exception.getMessage());
			throw new GetAllProfileInternalServerErrorException(exception.getMessage());
		}
	}

	private Iterable<ProfileResponseDTO> request() {
		LOGGER.info("request - get all profiles");
		Iterable<ProfileResponseDTO> profiles = this.profileDatabase.getAll();
		LOGGER.info("request - profiles : {}", profiles);

		return profiles;
	}

}
