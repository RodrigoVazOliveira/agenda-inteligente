package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateDiaryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.CreateDiaryBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.CreateDiaryInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.DiaryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateDiaryServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class CreateDiaryService implements CreateDiaryServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateDiaryService.class);
	private final DiaryDatabase diaryDatabase;

	public CreateDiaryService(DiaryDatabase diaryDatabase) {
		this.diaryDatabase = diaryDatabase;
	}

	@Override
	public DiaryResponseDTO run(CreateDiaryRequestDTO createDiaryRequestDTO) {
		try {
			return request(createDiaryRequestDTO);
		} catch (FeignClientException exception) {
			requestError(exception);
			return null;
		} catch (FeignException exception) {
			throw new CreateDiaryInternalServerErrorException(exception.getMessage());
		}

	}

	private void requestError(FeignClientException exception) {
		LOGGER.error("run - status: {}, message : {}", exception.status(), exception.getMessage());
		if (exception.status() == 400) {
			throw new CreateDiaryBadRequestException(exception.getMessage());
		}

		throw new CreateDiaryInternalServerErrorException(exception.getMessage());
	}

	private DiaryResponseDTO request(CreateDiaryRequestDTO createDiaryRequestDTO) {
		LOGGER.info("request - createDiaryRequestDTO : {}", createDiaryRequestDTO);
		DiaryResponseDTO diaryResponseDTO = this.diaryDatabase.create(createDiaryRequestDTO);
		LOGGER.info("request - diaryResponseDTO : {}", diaryResponseDTO);

		return diaryResponseDTO;
	}

}
