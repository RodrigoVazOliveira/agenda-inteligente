package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.DiaryBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.DiaryInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.DiaryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetDiaryByEmailProfileServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class GetDiaryByEmailProfileService implements GetDiaryByEmailProfileServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetDiaryByEmailProfileService.class);
	private final DiaryDatabase diaryDatabase;

	public GetDiaryByEmailProfileService(DiaryDatabase diaryDatabase) {
		this.diaryDatabase = diaryDatabase;
	}

	@Override
	public Iterable<DiaryResponseDTO> run(String email) {
		try {
			return request(email);
		} catch (FeignClientException exception) {
			requestError(exception);
			return null;
		} catch (FeignException exception) {
			LOGGER.error("run - status: {}, message : {}", exception.status(), exception.getMessage());
			throw new DiaryInternalServerErrorException(exception.getMessage());
		}

	}

	private void requestError(FeignClientException exception) {
		LOGGER.error("requestError - status: {}, message : {}", exception.status(), exception.getMessage());
		if (exception.status() == 400) {
			throw new DiaryBadRequestException(exception.getMessage());
		}

		throw new DiaryInternalServerErrorException(exception.getMessage());
	}

	private Iterable<DiaryResponseDTO> request(String email) {
		LOGGER.info("request - email : {}", email);
		Iterable<DiaryResponseDTO> diaryResponseDTOs = this.diaryDatabase.getDiaryByEmailProfile(email);
		LOGGER.info("request - diaryResponseDTOs : {}", diaryResponseDTOs);

		return diaryResponseDTOs;
	}

}
