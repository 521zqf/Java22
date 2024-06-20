import java.util.List;

public class ShowtimeService {
    private ShowtimeDAO showtimeDAO = new ShowtimeDAO();

    public ShowtimeService() {
    }

    public ShowtimeService(ShowtimeDAO showtimeDAO) {
        this.showtimeDAO = showtimeDAO;
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeDAO.getAllShowtimes();
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeDAO.getShowtimeById(id);
    }

    public void saveShowtime(Showtime showtime) {
        showtimeDAO.saveShowtime(showtime);
    }

    public void deleteShowtime(Long id) {
        showtimeDAO.deleteShowtime(id);
    }
}
