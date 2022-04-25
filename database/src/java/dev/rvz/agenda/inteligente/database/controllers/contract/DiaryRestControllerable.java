package dev.rvz.agenda.inteligente.database.controllers.contract;

import dev.rvz.agenda.inteligente.database.dtos.CreateDiaryDTO;
import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface DiaryRestControllerable {

	Diary create(CreateDiaryDTO createDiaryDTO);

	Diary getById(Long id);

	Iterable<Diary> getAll();

	Iterable<Diary> getDiaryByEmailProfile(String email);
}
