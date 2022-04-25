package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.DiaryBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.diaries.DiaryInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.DiaryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetDiaryByIdServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class GetDiaryByIdService implements GetDiaryByIdServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetDiaryByIdService.class);
	private final DiaryDatabase diaryDatabase;

	public GetDiaryByIdService(DiaryDatabase diaryDatabase) {
		this.diaryDatabase = diaryDatabase;
	}

	@Override
	public DiaryResponseDTO run(Long id) {
		try {
			return request(id);
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

	private DiaryResponseDTO request(Long id) {
		LOGGER.info("run - id : {}", id);
		DiaryResponseDTO diaryResponseDTO = this.diaryDatabase.getById(id);
		LOGGER.info("run - diaryResponseDTO : {}", diaryResponseDTO);

		return diaryResponseDTO;
	}

}
