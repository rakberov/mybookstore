package mybookstore.mybookstore.controller;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.BookService;
import mybookstore.mybookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/create")
    public String create (@ModelAttribute @Valid Book book){
        bookService.create(book);
        return "home";
    }


}
