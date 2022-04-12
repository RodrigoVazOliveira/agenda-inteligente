package dev.rvz.agenda.inteligente.database.services.contracts;

import dev.rvz.agenda.inteligente.database.entities.Diary;

public interface CreateDiaryServiceable {

	Diary execute(Diary diary);
}
