package dev.rvz.agenda.inteligente.database.services.contracts;

import dev.rvz.agenda.inteligente.database.entities.Profile;

public interface GetAllProfilesServiceable {

	Iterable<Profile> execute();
}
