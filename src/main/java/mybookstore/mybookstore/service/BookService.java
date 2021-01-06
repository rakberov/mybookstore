package mybookstore.mybookstore.service;

import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.BookReview;

import java.util.List;

public interface BookService {

    void create(Book book);

    void update(Book book);

    void delete(Book book);

    Book getByIsbn(String isbn);

    List<Book> getAllBook();

    void review(String isbn, BookReview review);

}
