package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

public interface GetAllDiaryServicePort {
	Iterable<DiaryResponseDTO> run();
}
