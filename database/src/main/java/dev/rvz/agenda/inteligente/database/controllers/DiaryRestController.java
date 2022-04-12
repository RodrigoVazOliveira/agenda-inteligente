package dev.rvz.agenda.inteligente.database.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.database.controllers.contract.DiaryRestControllerable;
import dev.rvz.agenda.inteligente.database.dtos.CreateDiaryDTO;
import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.services.contracts.CreateDiaryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.GetDiaryByIdServiceable;

@RestController
@RequestMapping(path = "/diaries")
class DiaryRestController implements DiaryRestControllerable {
	private final static Logger LOGGER = LoggerFactory.getLogger(DiaryRestController.class);
	private final CreateDiaryServiceable createDiaryService;
	private final GetDiaryByIdServiceable getDiaryByIdService;
	private final GetAllDiaryServiceable getAllDiaryService;
	private final GetDiaryByEmailProfileServiceable getDiaryByEmailProfileServiceable;

	public DiaryRestController(CreateDiaryServiceable createDiaryService, GetDiaryByIdServiceable getDiaryByIdService,
			GetAllDiaryServiceable getAllDiaryService,
			GetDiaryByEmailProfileServiceable getDiaryByEmailProfileServiceable) {
		this.createDiaryService = createDiaryService;
		this.getDiaryByIdService = getDiaryByIdService;
		this.getAllDiaryService = getAllDiaryService;
		this.getDiaryByEmailProfileServiceable = getDiaryByEmailProfileServiceable;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Override
	public Diary create(@RequestBody CreateDiaryDTO createDiaryDTO) {
		LOGGER.info("create - input createDiaryDTO: {}", createDiaryDTO);
		Diary diary = createDiaryDTO.convertDTOToEntityDiary();
		return this.createDiaryService.execute(diary);
	}

	@Override
	public Diary getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Diary> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Diary> getDiaryByEmailProfile(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
