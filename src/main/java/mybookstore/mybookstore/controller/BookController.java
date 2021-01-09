package mybookstore.mybookstore.controller;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.BookReview;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.BookService;
import mybookstore.mybookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Valid Book book) {
        bookService.create(book);
        return "redirect:/home";
    }

    @GetMapping(value = "/findByIsbn")
    public String findByIsbn(Model model, @RequestParam("isbn") String isbn) {
        Book book = bookService.getByIsbn(isbn);
        model.addAttribute("book", book);
        return "bookUpdate";
    }

    @PostMapping(value = "/update", params = "action=Update")
    public String update(@ModelAttribute @Valid Book book) {
        bookService.update(book);
        return "redirect:/home";
    }

    @PostMapping(value = "/update", params = "action=Delete")
    public String delete(@ModelAttribute @Valid Book book) {
        bookService.delete(book);
        return "redirect:/home";
    }

    @GetMapping(value = "/view")
    public String view(Model model, @RequestParam("isbn") String isbn) {
        Book book = bookService.getByIsbn(isbn);
        model.addAttribute("book", book);
        model.addAttribute("review", new BookReview());
        return "bookView";
    }

    @PostMapping(value = "/review")
    public String review(@RequestParam("isbn") String isbn,
                         @ModelAttribute BookReview review) {
        bookService.review(isbn, review);
        return "redirect:/home";
    }

    @PostMapping(value = "/addToCart")
    public String addToCart(@RequestParam("isbn") String isbn) {
        bookService.addToCart(isbn);
        return "redirect:/home";
    }
}
