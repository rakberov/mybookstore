package mybookstore.mybookstore.service.impl;

import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) {
        System.out.println("Register " + user);
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }
}
