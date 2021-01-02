package mybookstore.mybookstore.exception;

public class NotFoundException extends RuntimeException {

    public static final int HTTP_CODE = 404;

    public NotFoundException(String message) {
        super(message);
    }
}

