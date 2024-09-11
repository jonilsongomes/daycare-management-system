package em.dio.daycare_management_system.service.exception;

public class NotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found.");
    }
}
