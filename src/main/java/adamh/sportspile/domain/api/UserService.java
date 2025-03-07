package adamh.sportspile.domain.api;

import adamh.sportspile.domain.dto.UserRegistration;
import adamh.sportspile.domain.user.User;
import adamh.sportspile.domain.user.UserDao;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration) {
        User user = UserMapper.map(userRegistration);
        hashPasswordWithSha256(user);
        userDao.save(user);
    }

    private void hashPasswordWithSha256(User user) {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}
