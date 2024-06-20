import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}