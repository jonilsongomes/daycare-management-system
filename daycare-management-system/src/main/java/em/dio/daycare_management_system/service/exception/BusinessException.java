package em.dio.daycare_management_system.service.exception;

public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

}
