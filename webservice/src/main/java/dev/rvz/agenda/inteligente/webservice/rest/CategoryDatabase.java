package dev.rvz.agenda.inteligente.webservice.rest;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.exceptions.categories.GetAllCategoriesErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${url.base.categories}", name = "CategoryDatabase", value = "CategoryDatabase")
public interface CategoryDatabase {
    Logger LOGGER = LoggerFactory.getLogger(CategoryDatabase.class);

    @PostMapping
    CategoryResponseDTO create(@RequestBody CategoryRequestDTO categoryRequestDTO);

    @GetMapping
    @CircuitBreaker(name = "webservice1_getallcategories", fallbackMethod = "getAllErrors")
    Iterable<CategoryResponseDTO> getAll();

    default Iterable<CategoryResponseDTO> getAllErrors(RuntimeException e) {
        LOGGER.info("status circuit breaker : {}", e.getMessage());
        throw new GetAllCategoriesErrorException("Servidor do banco de dados indisponivel");
    }
}
