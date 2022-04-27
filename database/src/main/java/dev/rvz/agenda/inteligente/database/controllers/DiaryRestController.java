package dev.rvz.agenda.inteligente.database.controllers;

import dev.rvz.agenda.inteligente.database.controllers.contract.DiaryRestControllerable;
import dev.rvz.agenda.inteligente.database.dtos.CreateDiaryDTO;
import dev.rvz.agenda.inteligente.database.entities.Diary;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.CreateDiaryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetAllDiaryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetDiaryByEmailProfileServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.diaries.GetDiaryByIdServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/diaries")
class DiaryRestController implements DiaryRestControllerable {
	private final static Logger LOGGER = LoggerFactory.getLogger(DiaryRestController.class);
	private final CreateDiaryServiceable createDiaryService;
	private final GetDiaryByIdServiceable getDiaryByIdService;
	private final GetAllDiaryServiceable getAllDiaryService;
	private final GetDiaryByEmailProfileServiceable getDiaryByEmailProfileService;

	public DiaryRestController(CreateDiaryServiceable createDiaryService, GetDiaryByIdServiceable getDiaryByIdService,
			GetAllDiaryServiceable getAllDiaryService,
			GetDiaryByEmailProfileServiceable getDiaryByEmailProfileService) {
		this.createDiaryService = createDiaryService;
		this.getDiaryByIdService = getDiaryByIdService;
		this.getAllDiaryService = getAllDiaryService;
		this.getDiaryByEmailProfileService = getDiaryByEmailProfileService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Override
	public Diary create(@RequestBody CreateDiaryDTO createDiaryDTO) {
		LOGGER.info("create - input createDiaryDTO: {}", createDiaryDTO);
		Diary diary = createDiaryDTO.convertDTOToEntityDiary();
		return this.createDiaryService.execute(diary);
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Diary getById(@PathVariable Long id) {
		LOGGER.info("getById input id: {}", id);
		return this.getDiaryByIdService.execute(id);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<Diary> getAll() {
		return this.getAllDiaryService.execute();
	}

	@GetMapping(path = "/profile/{email}")
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<Diary> getDiaryByEmailProfile(@PathVariable String email) {
		LOGGER.info("getDiaryByEmailProfile input email: {}", email);
		return this.getDiaryByEmailProfileService.execute(email);
	}

}
