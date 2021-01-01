package mybookstore.mybookstore.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.exception.AccessDeniedException;
import mybookstore.mybookstore.exception.NotFoundException;
import mybookstore.mybookstore.exception.PasswordAlgorithmException;
import mybookstore.mybookstore.exception.PasswordMismatchException;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.model.enums.Role;
import mybookstore.mybookstore.repository.UserRepository;
import mybookstore.mybookstore.service.UserService;
import mybookstore.mybookstore.util.PasswordHasher;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordHasher passwordHasher;
    private final UserRepository userRepository;

    @Override
    public User register(User user) {

        try {
            if (!user.getPassword().equals(user.getConfirmPassword()))
                throw new PasswordMismatchException("Password don't match!");

            String hashPassword = passwordHasher.hashPassword(user.getPassword());
            user.setPassword(hashPassword);
            user.setConfirmPassword(hashPassword);

            user.setRole(Role.User);
            user = userRepository.save(user);

        } catch (PasswordMismatchException e) {
            log.error("register.PasswordMismatchException.error", e);
            throw e;
        } catch (NoSuchAlgorithmException e) {
            log.error("register.NoSuchAlgorithmException.error", e);
            throw new PasswordAlgorithmException(e.getMessage());
        }
        return user;
    }

    @Override
    public User login(String email, String password) {

        User user = null;
        try {

            user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new NotFoundException("email : " + email + " not found "));

            String hashPassword = passwordHasher.hashPassword(password);
            if (!hashPassword.equals(user.getConfirmPassword()))
                throw new AccessDeniedException("Password incorrect");
            log.info("User found: {}", user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return user;
    }
}
