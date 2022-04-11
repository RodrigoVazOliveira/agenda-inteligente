package dev.rvz.agenda.inteligente.database.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

}
