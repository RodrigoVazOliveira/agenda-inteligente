package dev.rvz.agenda.inteligente.database.services.diaries;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.exceptions.diaries.DiaryByIdNotFoundException;
import dev.rvz.agenda.inteligente.database.repositories.DiaryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetDiaryByIdServiceable;

@Service
public class GetDiaryByIdService implements GetDiaryByIdServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetDiaryByIdService.class);
	private final DiaryRepository diaryRepository;

	public GetDiaryByIdService(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}

	@Transactional
	@Override
	public Diary execute(Long id) {
		LOGGER.info("execute input id: {}", id);
		Optional<Diary> diaryOptional = this.diaryRepository.findById(id);
		findDiaryByIdIsEmpty(id, diaryOptional);
		Diary diary = diaryOptional.get();
		LOGGER.info("execute output diary: {}", diary);

		return diary;
	}

	private void findDiaryByIdIsEmpty(Long id, Optional<Diary> diaryOptional) {
		if (diaryOptional.isEmpty()) {
			LOGGER.error("findDiaryByIdIsEmpty - diary with id " + id + " not exist");
			throw new DiaryByIdNotFoundException("diario com id " + id + " nao existe");
		}
	}

}
