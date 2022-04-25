package dev.rvz.agenda.inteligente.database.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.database.controllers.contract.ProfileRestControllerable;
import dev.rvz.agenda.inteligente.database.dtos.CreateProfileDTO;
import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.CreateProfileServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.GetAllProfilesServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.GetByIdProfileServiceable;

@RestController
@RequestMapping(path = "/profiles")
class ProfileRestController implements ProfileRestControllerable {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileRestController.class);
	private final CreateProfileServiceable createProfileService;
	private final GetAllProfilesServiceable getAllProfilesService;
	private final GetByIdProfileServiceable getByIdProfileService;

	public ProfileRestController(CreateProfileServiceable createProfileService,
			GetAllProfilesServiceable getAllProfilesService, GetByIdProfileServiceable getByIdProfileService) {
		this.createProfileService = createProfileService;
		this.getAllProfilesService = getAllProfilesService;
		this.getByIdProfileService = getByIdProfileService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profile create(@RequestBody CreateProfileDTO createProfileDTO) {
		LOGGER.info("create - input createProfileDTO: {}", createProfileDTO);
		return this.createProfileService.execute(createProfileDTO.convertDTOToEntityProfile());
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<Profile> getAll() {
		LOGGER.info("getAll - find all profiles");
		return this.getAllProfilesService.execute();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Profile getById(Long id) {
		LOGGER.info("getById - input id: {}", id);
		return this.getByIdProfileService.execute(id);
	}
}
