package dev.rvz.agenda.inteligente.database.services.contracts.diaries;

import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface GetAllDiaryServiceable {

	Iterable<Diary> execute();
}
