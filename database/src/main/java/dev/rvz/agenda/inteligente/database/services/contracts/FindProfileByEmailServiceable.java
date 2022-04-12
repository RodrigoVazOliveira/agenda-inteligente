package dev.rvz.agenda.inteligente.database.services.contracts;

import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface FindProfileByEmailServiceable {
	Profile execute(String email);
}