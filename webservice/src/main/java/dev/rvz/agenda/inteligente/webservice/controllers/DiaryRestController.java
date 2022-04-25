package dev.rvz.agenda.inteligente.webservice.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.webservice.controllers.port.DiaryRestControllerPort;
import dev.rvz.agenda.inteligente.webservice.dtos.CreateDiaryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateDiaryServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllDiaryServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetDiaryByEmailProfileServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetDiaryByIdServicePort;

@RestController
@RequestMapping(path = "/diaries")
class DiaryRestController implements DiaryRestControllerPort {
	private final static Logger LOGGER = LoggerFactory.getLogger(DiaryRestController.class);
	private final CreateDiaryServicePort createDiaryService;
	private final GetAllDiaryServicePort getAllDiaryService;
	private final GetDiaryByIdServicePort getDiaryByIdService;
	private final GetDiaryByEmailProfileServicePort getDiaryByEmailProfileService;

	public DiaryRestController(CreateDiaryServicePort createDiaryService, GetAllDiaryServicePort getAllDiaryService,
			GetDiaryByIdServicePort getDiaryByIdService,
			GetDiaryByEmailProfileServicePort getDiaryByEmailProfileService) {
		this.createDiaryService = createDiaryService;
		this.getAllDiaryService = getAllDiaryService;
		this.getDiaryByIdService = getDiaryByIdService;
		this.getDiaryByEmailProfileService = getDiaryByEmailProfileService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Override
	public DiaryResponseDTO create(@RequestBody @Valid CreateDiaryRequestDTO diaryRequestDTO) {
		LOGGER.info("create - diaryRequestDTO : {}", diaryRequestDTO);
		DiaryResponseDTO diaryResponseDTO = this.createDiaryService.run(diaryRequestDTO);
		LOGGER.info("create - diaryResponseDTO : {}", diaryResponseDTO);

		return diaryResponseDTO;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<DiaryResponseDTO> getAll() {
		LOGGER.info("get all diaries");
		return this.getAllDiaryService.run();
	}

	@Override
	public DiaryResponseDTO getById(Long id) {
		LOGGER.info("getById - id : {}", id);
		DiaryResponseDTO diaryResponseDTO = this.getDiaryByIdService.run(id);
		LOGGER.info("getById - diaryResponseDTO : {}", diaryResponseDTO);

		return diaryResponseDTO;
	}

	@Override
	public Iterable<DiaryResponseDTO> getDiaryByEmailProfile(String email) {
		LOGGER.info("getDiaryByEmailProfile - email : {}", email);
		return this.getDiaryByEmailProfileService.run(email);
	}

}
