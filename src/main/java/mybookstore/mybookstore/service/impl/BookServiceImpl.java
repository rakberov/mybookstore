package mybookstore.mybookstore.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.exception.NotFoundException;
import mybookstore.mybookstore.model.*;
import mybookstore.mybookstore.repository.BookRepository;
import mybookstore.mybookstore.repository.CartRepository;
import mybookstore.mybookstore.service.BookService;
import mybookstore.mybookstore.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final SessionService sessionService;
    private final CartRepository cartRepository;


    @Override
    public void create(Book book) {
        log.debug("book.create start");
        bookRepository.save(book);
        log.debug("book.create end");
    }

    @Override
    public void update(Book newBook) {

        log.debug("book.update start");

        Book oldBook = bookRepository.findByIsbn(newBook.getIsbn())
                .orElseThrow(() -> new NotFoundException("isbn: " + newBook.getIsbn() + " not found"));
        oldBook.setDescription(newBook.getDescription());
        oldBook.setGenre(newBook.getGenre());
        oldBook.setName(newBook.getName());
        oldBook.setPageSize(newBook.getPageSize());
        oldBook.setPrice(newBook.getPrice());
        oldBook.setPublishDate(newBook.getPublishDate());

        bookRepository.save(oldBook);

        log.debug("book.update end");

    }

    @Override
    public void delete(Book book) {
        log.debug("book.delete start");

        String isbn = book.getIsbn();
        book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new NotFoundException("isbn: " + isbn + " not found"));
        bookRepository.delete(book);

        log.debug("book.delete end");

    }

    @Override
    public Book getByIsbn(String isbn) {
        log.debug("getByIsbn start: {}", isbn);
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new NotFoundException("isbn: " + isbn + " not found"));
        log.debug("getByIsbn end: {}", isbn);
        return book;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void review(String isbn, BookReview review) {
        log.info("review.start for isbn {}", isbn);

        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new NotFoundException("isbn: " + isbn + " not found"));

        Session session = sessionService.findActiveSession();
        User user = session.getUser();
        review.setUser(user);
        review.setBook(book);
        List<BookReview> reviews = book.getReviews();
        reviews.add(review);
        book.setReviews(reviews);
        bookRepository.save(book);

        log.info("review.end for isbn {}", isbn);
    }

    @Override
    public void addToCart(String isbn) {
        log.info("addToCart.start for isbn {}", isbn);

        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new NotFoundException("isbn: " + isbn + " not found"));
        Session session = sessionService.findActiveSession();
        User user = session.getUser();

        Cart cart = cartRepository.findByUser(user).orElse(new Cart());
        cart.setUser(user);
        List<Book> books = cart.getBooks();
        books.add(book);
        cart.setBooks(books);
        cartRepository.save(cart);

        log.info("addToCart.end for isbn {}", isbn);
    }
}
