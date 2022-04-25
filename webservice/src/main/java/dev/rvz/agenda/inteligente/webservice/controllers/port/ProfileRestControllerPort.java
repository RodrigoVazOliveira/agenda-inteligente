package dev.rvz.agenda.inteligente.webservice.controllers.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;

public interface ProfileRestControllerPort {

	ProfileResponseDTO create(CreateProfileRequestDTO createProfileRequestDTO);

	Iterable<ProfileResponseDTO> getAll();

	ProfileResponseDTO getById(Long id);
}
