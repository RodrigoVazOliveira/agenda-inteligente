package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;

public interface GetAllProfilesServicePort {

	Iterable<ProfileResponseDTO> run();

}
