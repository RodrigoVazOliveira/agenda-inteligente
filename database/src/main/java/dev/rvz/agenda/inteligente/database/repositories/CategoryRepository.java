package dev.rvz.agenda.inteligente.database.repositories;

import dev.rvz.agenda.inteligente.database.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByName(String name);

	Boolean existsByName(String name);
}
