package dev.rvz.agenda.inteligente.database.repositories;

import dev.rvz.agenda.inteligente.database.entities.Diary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

	@Query(value = "SELECT d FROM Diary d WHERE d.profile.contact.email.address = ?1")
	Iterable<Diary> findAllByProfileEmail(String email);
}