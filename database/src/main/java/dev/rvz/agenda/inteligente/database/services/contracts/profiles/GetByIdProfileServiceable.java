package dev.rvz.agenda.inteligente.database.services.contracts.profiles;

import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface GetByIdProfileServiceable {

	Profile execute(Long id);
}