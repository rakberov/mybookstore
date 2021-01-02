package mybookstore.mybookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.repository.BookRepository;
import mybookstore.mybookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Book getByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }
}
