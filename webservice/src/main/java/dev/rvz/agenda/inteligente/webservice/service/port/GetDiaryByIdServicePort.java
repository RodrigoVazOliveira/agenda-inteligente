package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

public interface GetDiaryByIdServicePort {
	DiaryResponseDTO run(Long id);
}
