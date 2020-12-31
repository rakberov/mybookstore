package mybookstore.mybookstore.service;

import mybookstore.mybookstore.model.User;

public interface LoginService {
    User  register(User user);

    User login(String email, String password);
}
