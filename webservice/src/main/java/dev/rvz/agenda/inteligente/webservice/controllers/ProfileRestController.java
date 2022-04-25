package dev.rvz.agenda.inteligente.webservice.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.webservice.controllers.port.ProfileRestControllerPort;
import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateProfileServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllProfilesServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetByIdProfileServicePort;

@RestController
@RequestMapping(path = "/profiles")
class ProfileRestController implements ProfileRestControllerPort {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfileRestController.class);
	private final CreateProfileServicePort createProfileService;
	private final GetAllProfilesServicePort getAllProfilesService;
	private final GetByIdProfileServicePort getByIdProfileService;

	public ProfileRestController(CreateProfileServicePort createProfileService,
			GetAllProfilesServicePort getAllProfilesService, GetByIdProfileServicePort getByIdProfileService) {
		this.createProfileService = createProfileService;
		this.getAllProfilesService = getAllProfilesService;
		this.getByIdProfileService = getByIdProfileService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Override
	public ProfileResponseDTO create(@RequestBody @Valid CreateProfileRequestDTO createProfileRequestDTO) {
		LOGGER.info("create - createProfileRequestDTO: {}", createProfileRequestDTO);
		ProfileResponseDTO profileResponseDTO = this.createProfileService.run(createProfileRequestDTO);
		LOGGER.info("create - profileResponseDTO: {}", profileResponseDTO);

		return profileResponseDTO;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<ProfileResponseDTO> getAll() {
		LOGGER.info("getAll - get all profiles");

		return this.getAllProfilesService.run();
	}

	@GetMapping(path = "/{id}")
	@Override
	public ProfileResponseDTO getById(@PathVariable Long id) {
		LOGGER.info("getById - id : {}", id);
		return this.getByIdProfileService.run(id);
	}

}
