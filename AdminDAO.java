import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM admins");

            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                admin.setCinemaId(resultSet.getLong("cinema_id"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return admins;
    }

    public Admin getAdminById(Long id) {
        Admin admin = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM admins WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                admin.setCinemaId(resultSet.getLong("cinema_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return admin;
    }

    public void saveAdmin(Admin admin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            if (admin.getId() == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO admins (username, password, cinema_id) VALUES (?, ?, ?)");
            } else {
                preparedStatement = connection.prepareStatement("UPDATE admins SET username = ?, password = ?, cinema_id = ? WHERE id = ?");
                preparedStatement.setLong(4, admin.getId());
            }
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setLong(3, admin.getCinemaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    public void deleteAdmin(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM admins WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    public static class UserService {
    }
}
