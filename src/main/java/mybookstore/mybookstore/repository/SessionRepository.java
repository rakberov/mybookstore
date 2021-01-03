package mybookstore.mybookstore.repository;

import mybookstore.mybookstore.model.Session;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.model.enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByStatus(SessionStatus status);

}
