import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    two DBUtil = new two();

    // 获取所有票据的方法
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tickets");

            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setUserId(resultSet.getLong("user_id"));
                ticket.setCinemaId(resultSet.getLong("cinema_id"));
                ticket.setMovieId(resultSet.getLong("movie_id"));
                ticket.setSeatNumber(resultSet.getString("seat_number"));
                ticket.setShowtimeId(resultSet.getLong("show_time"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return tickets;
    }

    // 根据ID获取票据的方法
    public Ticket getTicketById(Long id) {
        Ticket ticket = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM tickets WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setUserId(resultSet.getLong("user_id"));
                ticket.setCinemaId(resultSet.getLong("cinema_id"));
                ticket.setMovieId(resultSet.getLong("movie_id"));
                ticket.setSeatNumber(resultSet.getString("seat_number"));
                ticket.setShowtimeId(resultSet.getLong("show_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return ticket;
    }

    // 保存票据的方法
    public void saveTicket(Ticket ticket) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            if (ticket.getId() == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO tickets (user_id, cinema_id, movie_id, seat_number, show_time) VALUES (?, ?, ?, ?, ?)");
            } else {
                preparedStatement = connection.prepareStatement("UPDATE tickets SET user_id = ?, cinema_id = ?, movie_id = ?, seat_number = ?, show_time = ? WHERE id = ?");
                preparedStatement.setLong(6, ticket.getId());
            }
            preparedStatement.setLong(1, ticket.getUserId());
            preparedStatement.setLong(2, ticket.getCinemaId());
            preparedStatement.setLong(3, ticket.getMovieId());
            preparedStatement.setString(4, ticket.getSeatNumber());
            preparedStatement.setLong(5, ticket.getShowtimeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    // 删除票据的方法
    public void deleteTicket(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM tickets WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}