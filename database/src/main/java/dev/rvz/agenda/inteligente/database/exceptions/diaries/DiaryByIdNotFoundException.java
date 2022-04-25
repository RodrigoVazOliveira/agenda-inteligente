package dev.rvz.agenda.inteligente.database.exceptions.diaries;

public class DiaryByIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8259107933630816302L;
	private final Integer code = 400;

	public DiaryByIdNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
