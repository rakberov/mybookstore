package mybookstore.mybookstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

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
