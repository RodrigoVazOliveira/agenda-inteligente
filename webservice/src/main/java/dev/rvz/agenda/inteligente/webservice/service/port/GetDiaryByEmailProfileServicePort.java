package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

public interface GetDiaryByEmailProfileServicePort {
	Iterable<DiaryResponseDTO> run(String email);
}
