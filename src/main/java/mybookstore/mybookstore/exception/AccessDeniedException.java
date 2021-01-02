package mybookstore.mybookstore.exception;

public class AccessDeniedException extends RuntimeException {

    public static final int HTTP_CODE = 401;

    public AccessDeniedException(String message) {
        super(message);
    }
}
