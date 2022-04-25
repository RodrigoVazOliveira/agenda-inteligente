package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateDiaryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

public interface CreateDiaryServicePort {
	DiaryResponseDTO run(CreateDiaryRequestDTO createDiaryRequestDTO);
}
