package dev.rvz.agenda.inteligente.database.services.diaries;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.repositories.DiaryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetAllDiaryServiceable;

@Service
public class GetAllDiaryService implements GetAllDiaryServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetAllDiaryService.class);
	private final DiaryRepository diaryRepository;

	public GetAllDiaryService(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}

	@Transactional
	@Override
	public Iterable<Diary> execute() {
		Iterable<Diary> diaries = this.diaryRepository.findAll();
		LOGGER.info("execute output diaries: {}", diaries);

		return diaries;
	}

}
