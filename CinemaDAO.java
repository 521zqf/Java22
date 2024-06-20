import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {
    public List<Cinema> getAllCinemas() {
        List<Cinema> cinemas = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cinemas");

            while (resultSet.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(resultSet.getLong("id"));
                cinema.setName(resultSet.getString("name"));
                cinema.setLocation(resultSet.getString("location"));
                cinemas.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return cinemas;
    }

    public Cinema getCinemaById(Long id) {
        Cinema cinema = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM cinemas WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cinema = new Cinema();
                cinema.setId(resultSet.getLong("id"));
                cinema.setName(resultSet.getString("name"));
                cinema.setLocation(resultSet.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return cinema;
    }

    public void saveCinema(Cinema cinema) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            if (cinema.getId() == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO cinemas (name, location) VALUES (?, ?)");
            } else {
                preparedStatement = connection.prepareStatement("UPDATE cinemas SET name = ?, location = ? WHERE id = ?");
                preparedStatement.setLong(3, cinema.getId());
            }
            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    public void deleteCinema(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        two DBUtil = new two();
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM cinemas WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}

