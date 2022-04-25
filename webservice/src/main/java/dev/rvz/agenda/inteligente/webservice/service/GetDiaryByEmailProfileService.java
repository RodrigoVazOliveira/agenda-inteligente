package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.rest.DiaryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetDiaryByEmailProfileServicePort;

@Service
public class GetDiaryByEmailProfileService implements GetDiaryByEmailProfileServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetDiaryByEmailProfileService.class);
	private final DiaryDatabase diaryDatabase;

	public GetDiaryByEmailProfileService(DiaryDatabase diaryDatabase) {
		this.diaryDatabase = diaryDatabase;
	}

	@Override
	public Iterable<DiaryResponseDTO> run(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
