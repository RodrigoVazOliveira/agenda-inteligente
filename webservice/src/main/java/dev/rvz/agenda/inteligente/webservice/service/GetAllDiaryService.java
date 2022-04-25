package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.DiaryInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.DiaryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllDiaryServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class GetAllDiaryService implements GetAllDiaryServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetAllDiaryService.class);
	private final DiaryDatabase diaryDatabase;

	public GetAllDiaryService(DiaryDatabase diaryDatabase) {
		this.diaryDatabase = diaryDatabase;
	}

	@Override
	public Iterable<DiaryResponseDTO> run() {
		try {
			return request();
		} catch (FeignClientException exception) {
			LOGGER.error("run - status : {}, message : {}", exception.status(), exception.getMessage());
			throw new DiaryInternalServerErrorException(exception.getMessage());
		} catch (FeignException exception) {
			LOGGER.error("run - status : {}, message : {}", exception.status(), exception.getMessage());
			throw new DiaryInternalServerErrorException(exception.getMessage());
		}

	}

	private Iterable<DiaryResponseDTO> request() {
		LOGGER.info("request - get all diaries");
		Iterable<DiaryResponseDTO> diaryResponseDTOs = this.diaryDatabase.getAll();
		LOGGER.info("request - diaryResponse	DTOs : {}", diaryResponseDTOs);

		return diaryResponseDTOs;
	}

}
