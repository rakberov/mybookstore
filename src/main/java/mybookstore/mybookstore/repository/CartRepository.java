package mybookstore.mybookstore.repository;

import mybookstore.mybookstore.model.Book;
import mybookstore.mybookstore.model.Cart;
import mybookstore.mybookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
