package dev.rvz.agenda.inteligente.webservice.controllers.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateDiaryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

public interface DiaryRestControllerPort {

	DiaryResponseDTO create(CreateDiaryRequestDTO diaryRequestDTO);

	Iterable<DiaryResponseDTO> getAll();

	DiaryResponseDTO getById(Long id);

	Iterable<DiaryResponseDTO> getDiaryByEmailProfile(String email);
}
