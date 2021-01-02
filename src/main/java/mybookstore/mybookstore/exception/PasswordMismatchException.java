package mybookstore.mybookstore.exception;


public class PasswordMismatchException extends RuntimeException {

    public static final int HTTP_CODE = 400;


    public PasswordMismatchException(String message) {
        super(message);
    }
}
