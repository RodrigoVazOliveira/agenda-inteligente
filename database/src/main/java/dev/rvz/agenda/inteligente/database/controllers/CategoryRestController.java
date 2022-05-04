package dev.rvz.agenda.inteligente.database.controllers;

import dev.rvz.agenda.inteligente.database.controllers.contract.CategoryRestControllerable;
import dev.rvz.agenda.inteligente.database.dtos.CreateCategoryDTO;
import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.CreateCategoryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.GetAllCategoryServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
@CrossOrigin("*")
class CategoryRestController implements CategoryRestControllerable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryRestController.class);
    private final CreateCategoryServiceable createCategoryService;
    private final GetAllCategoryServiceable getAllCategoryService;

    public CategoryRestController(CreateCategoryServiceable createCategoryService,
                                  GetAllCategoryServiceable getAllCategoryService) {
        this.createCategoryService = createCategoryService;
        this.getAllCategoryService = getAllCategoryService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category create(@RequestBody CreateCategoryDTO createCategoryDTO) {
        LOGGER.info("create - input createCategoryDTO: {}", createCategoryDTO);
        return this.createCategoryService.execute(createCategoryDTO.convertDTOToEntityCategory());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Category> getAll() {
        Iterable<Category> categories = this.getAllCategoryService.execute();
        LOGGER.info("getAll - categories: {}", categories);
        return categories;
    }
}
