package mybookstore.mybookstore.exception;

public class PasswordAlgorithmException extends RuntimeException {

    public static final int HTTP_CODE = 400;

    public PasswordAlgorithmException(String message) {
        super(message);
    }
}
