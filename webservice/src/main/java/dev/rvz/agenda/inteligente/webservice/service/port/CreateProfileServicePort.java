package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;

public interface CreateProfileServicePort {
	ProfileResponseDTO run(CreateProfileRequestDTO createProfileRequestDTO);
}
