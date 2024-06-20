import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    two DBUtil = new two();

    public List<Showtime> getAllShowtimes() {
        List<Showtime> showtimes = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM showtimes");

            while (resultSet.next()) {
                Showtime showtime = new Showtime();
                showtime.setId(resultSet.getLong("id"));
                showtime.setMovieId(resultSet.getLong("movie_id"));
                showtime.setCinemaId(resultSet.getLong("cinema_id"));
                showtime.setShowtime(resultSet.getTimestamp("showtime").toLocalDateTime());
                showtimes.add(showtime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return showtimes;

    }

    public Showtime getShowtimeById(Long id) {
        Showtime showtime = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM showtimes WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                showtime = new Showtime();
                showtime.setId(resultSet.getLong("id"));
                showtime.setMovieId(resultSet.getLong("movie_id"));
                showtime.setCinemaId(resultSet.getLong("cinema_id"));
                showtime.setShowtime(resultSet.getTimestamp("showtime").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return showtime;
    }

    public void saveShowtime(Showtime showtime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            if (showtime.getId() == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO showtimes (movie_id, cinema_id, showtime) VALUES (?, ?, ?)");
            } else {
                preparedStatement = connection.prepareStatement("UPDATE showtimes SET movie_id = ?, cinema_id = ?, showtime = ? WHERE id = ?");
                preparedStatement.setLong(4, showtime.getId());
            }
            preparedStatement.setLong(1, showtime.getMovieId());
            preparedStatement.setLong(2, showtime.getCinemaId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(showtime.getShowtime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    public void deleteShowtime(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM showtimes WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}
