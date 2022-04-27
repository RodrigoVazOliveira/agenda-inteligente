package dev.rvz.agenda.inteligente.database.services.profiles;

import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.FindProfileByIdServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.profiles.GetByIdProfileServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetByIdProfileService implements GetByIdProfileServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetByIdProfileService.class);
	private final FindProfileByIdServiceable findProfileByIdService;

	public GetByIdProfileService(FindProfileByIdServiceable findProfileByIdService) {
		this.findProfileByIdService = findProfileByIdService;
	}

	@Transactional
	@Override
	public Profile execute(Long id) {
		LOGGER.info("execute - input id: {}", id);
		Profile profile = this.findProfileByIdService.execute(id);
		LOGGER.info("execute output profile: {}", profile);

		return profile;
	}

}
