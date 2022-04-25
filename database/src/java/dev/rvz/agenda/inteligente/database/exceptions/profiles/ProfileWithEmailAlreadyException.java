package dev.rvz.agenda.inteligente.database.exceptions.profiles;

public class ProfileWithEmailAlreadyException extends RuntimeException {
	private static final long serialVersionUID = -6131961744710848154L;
	private final Integer code = 400;

	public ProfileWithEmailAlreadyException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
