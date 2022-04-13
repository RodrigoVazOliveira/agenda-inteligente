package dev.rvz.agenda.inteligente.database.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

	@Query(value = "SELECT d FROM Diary d WHERE d.profile.contact.email.address = ?1")
	Iterable<Diary> findAllByProfileEmail(String email);
}