package fr.treeptik.amazon.exception;

public class DAOException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
