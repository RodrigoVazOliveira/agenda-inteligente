package dev.rvz.agenda.inteligente.database.services.diaries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.repositories.DiaryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.CreateDiaryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.FindCategoryByNameServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.FindProfileByEmailServiceable;

@Service
public class CreateDiaryService implements CreateDiaryServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(CreateDiaryService.class);
	private final FindProfileByEmailServiceable FindProfileByEmailService;
	private final FindCategoryByNameServiceable FindCategoryByNameService;
	private final DiaryRepository diaryRepository;

	public CreateDiaryService(FindProfileByEmailServiceable findProfileByEmailService,
			FindCategoryByNameServiceable findCategoryByNameService, DiaryRepository diaryRepository) {
		FindProfileByEmailService = findProfileByEmailService;
		FindCategoryByNameService = findCategoryByNameService;
		this.diaryRepository = diaryRepository;
	}

	@Transactional
	@Override
	public Diary execute(Diary diary) {
		LOGGER.info("execute - input diary: {}", diary);
		setProfileByEmailInDiary(diary);
		setCategoryByNameInDiary(diary);

		return this.diaryRepository.save(diary);
	}

	private void setCategoryByNameInDiary(Diary diary) {
		String name = diary.getCategory().getName();
		Category cateogry = this.FindCategoryByNameService.execute(name);
		diary.setCategory(cateogry);
	}

	private void setProfileByEmailInDiary(Diary diary) {
		String address = diary.getProfile().getContact().getEmail().getAddress();
		Profile profile = this.FindProfileByEmailService.execute(address);
		diary.setProfile(profile);
	}

}
