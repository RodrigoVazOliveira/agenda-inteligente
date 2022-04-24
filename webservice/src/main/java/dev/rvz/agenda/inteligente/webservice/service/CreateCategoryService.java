package dev.rvz.agenda.inteligente.webservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.categories.CreateCategoryBadRequestException;
import dev.rvz.agenda.inteligente.webservice.exceptions.categories.CreateCategoryInternalServerErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.CategoryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateCategoryServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class CreateCategoryService implements CreateCategoryServicePort {
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateCategoryService.class);
	private final CategoryDatabase categoryDatabase;

	public CreateCategoryService(CategoryDatabase categoryDatabase) {
		this.categoryDatabase = categoryDatabase;
	}

	@Override
	public CategoryResponseDTO run(CategoryRequestDTO categoryRequestDTO) {
		LOGGER.info("run - categoryRequestDTO: {}", categoryRequestDTO);

		try {
			CategoryResponseDTO categoryResponseDTO = this.categoryDatabase.create(categoryRequestDTO);
			LOGGER.info("run - categoryResponseDTO: {}", categoryResponseDTO);
			return categoryResponseDTO;
		} catch (FeignClientException e) {
			LOGGER.error("run - status: {}, responseBody: {}", e.status(), e.responseBody());
			if (e.status() == 400) {
				throw new CreateCategoryBadRequestException(e.getMessage());
			}

			throw new CreateCategoryInternalServerErrorException(e.responseBody().toString());
		} catch (FeignException e) {
			throw new CreateCategoryInternalServerErrorException(e.getMessage());
		}
	}

}
