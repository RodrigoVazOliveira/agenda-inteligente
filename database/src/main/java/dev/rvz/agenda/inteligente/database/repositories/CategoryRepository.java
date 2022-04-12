package dev.rvz.agenda.inteligente.database.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.rvz.agenda.inteligente.database.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByName(String name);

}
