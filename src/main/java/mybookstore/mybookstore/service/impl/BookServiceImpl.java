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
}
