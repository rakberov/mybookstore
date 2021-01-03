package mybookstore.mybookstore.service;

import mybookstore.mybookstore.model.Session;
import mybookstore.mybookstore.model.User;

public interface SessionService {

    Session create(User user);

    Session findActiveSession();

}
