package mybookstore.mybookstore.controller;

import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.exception.AccessDeniedException;
import mybookstore.mybookstore.exception.NotFoundException;
import mybookstore.mybookstore.exception.PasswordMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PasswordMismatchException.class)
    public String handlePasswordMismatchException(Model model, HttpServletRequest request,
                                  PasswordMismatchException e) {
        log.debug("Handling password mismatch exception: ", e);

        model.addAttribute("datetime", LocalDateTime.now());
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("status", PasswordMismatchException.HTTP_CODE);
        model.addAttribute("message", e.getMessage());

        return "error";
    }

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(Model model, HttpServletRequest request,
                                  NotFoundException e) {
        log.debug("Handling not found exception: ", e);

        model.addAttribute("datetime", LocalDateTime.now());
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("status", NotFoundException.HTTP_CODE);
        model.addAttribute("message", e.getMessage());

        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(Model model, HttpServletRequest request,
                                          AccessDeniedException e) {
        log.debug("Handling access denied exception: ", e);

        model.addAttribute("datetime", LocalDateTime.now());
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("status", AccessDeniedException.HTTP_CODE);
        model.addAttribute("message", e.getMessage());

        return "error";
    }
        @ExceptionHandler(Exception.class)
        public String handleException(Model model, HttpServletRequest request,
                Exception e) {
            log.debug("Handling exception: ", e);

            model.addAttribute("datetime", LocalDateTime.now());
            model.addAttribute("url", request.getRequestURL());
            model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
            model.addAttribute("message", e.getMessage());

            return "error";
    }
}
