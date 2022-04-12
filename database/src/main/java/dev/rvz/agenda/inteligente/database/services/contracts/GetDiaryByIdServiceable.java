package dev.rvz.agenda.inteligente.database.services.contracts;

import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface GetDiaryByIdServiceable {

	Diary execute(Long id);
}