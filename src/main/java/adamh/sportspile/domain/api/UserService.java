package adamh.sportspile.domain.api;

import adamh.sportspile.domain.dto.UserRegistration;
import adamh.sportspile.domain.user.User;
import adamh.sportspile.domain.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration) {
        User user = UserMapper.map(userRegistration);
        userDao.save(user);
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
