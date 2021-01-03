package mybookstore.mybookstore.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.exception.NotFoundException;
import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.repository.BookRepository;
import mybookstore.mybookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {
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
        return null;
    }
}
