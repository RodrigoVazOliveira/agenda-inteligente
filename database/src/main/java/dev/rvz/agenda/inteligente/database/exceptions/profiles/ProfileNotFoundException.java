package dev.rvz.agenda.inteligente.database.exceptions.profiles;

public class ProfileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6061874754421571110L;
	private final Integer code = 400;

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

}
