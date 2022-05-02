package dev.rvz.agenda.inteligente.webservice.service;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.categories.GetAllCategoriesErrorException;
import dev.rvz.agenda.inteligente.webservice.rest.CategoryDatabase;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllCategoriesServicePort;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetAllCategoriesService implements GetAllCategoriesServicePort {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetAllCategoriesService.class);
    private final CategoryDatabase categoryDatabase;

    public GetAllCategoriesService(CategoryDatabase categoryDatabase) {
        this.categoryDatabase = categoryDatabase;
    }

    @Override
    public Iterable<CategoryResponseDTO> run() {
        LOGGER.info("run - init get all categories");

        try {
            Iterable<CategoryResponseDTO> categories = this.categoryDatabase.getAll();
            LOGGER.info("run - categories: {}", categories);

            return categories;
        } catch (FeignClientException ex) {
            throw new GetAllCategoriesErrorException(ex.getMessage());
        } catch (FeignException ex) {
            throw new GetAllCategoriesErrorException(ex.getMessage());
        }

    }


}
