package mybookstore.mybookstore.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.model.Session;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.model.enums.SessionStatus;
import mybookstore.mybookstore.repository.SessionRepository;
import mybookstore.mybookstore.service.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Session create(User user) {
        Session session = Session.builder()
                .user(user)
                .createTime(LocalDateTime.now())
                .status(SessionStatus.Active)
                .sessionId(UUID.randomUUID().toString())
                .build();
        return sessionRepository.save(session);
    }

    @Override
    public Session findActiveSession() {
        Session session = sessionRepository.findByStatus(SessionStatus.Active)
                .orElse(null);
        return session;
    }
}
