package dev.rvz.agenda.inteligente.database.services.diaries;

import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.repositories.DiaryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetDiaryByEmailProfileServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetDiaryByEmailProfileService implements GetDiaryByEmailProfileServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetDiaryByEmailProfileService.class);
	private final DiaryRepository diaryRepository;

	public GetDiaryByEmailProfileService(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}

	@Transactional
	@Override
	public Iterable<Diary> execute(String email) {
		LOGGER.info("execute input email: {}", email);
		Iterable<Diary> diaries = this.diaryRepository.findAllByProfileEmail(email);
		LOGGER.info("execute output diaries: {}", diaries);
		return diaries;
	}

}
