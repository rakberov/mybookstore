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
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Session create(User user) {
        inactiveSessions();

        Session session = Session.builder()
                .user(user)
                .startTime(LocalDateTime.now())
                .status(SessionStatus.Active)
                .sessionId(UUID.randomUUID().toString())
                .build();
        return sessionRepository.save(session);
    }

    private void inactiveSessions(){
        List<Session> sessions = sessionRepository.findAll();
        for (Session session: sessions){
            session.setStatus(SessionStatus.Inactive);
            session.setEndTime(LocalDateTime.now());
            sessionRepository.save(session);
        }
    }

    @Override
    public Session findActiveSession() {
        Session session = sessionRepository.findByStatus(SessionStatus.Active)
                .orElse(null);
        return session;
    }
}
