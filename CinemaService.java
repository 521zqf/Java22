import java.util.List;

public class CinemaService {
    private CinemaDAO cinemaDAO = new CinemaDAO();

    public List<Cinema> getAllCinemas() {
        return cinemaDAO.getAllCinemas();
    }

    public void saveCinema(Cinema cinema) {
        cinemaDAO.saveCinema(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaDAO.deleteCinema(id);
    }

    public Cinema getCinemaById(Long id) {
        return cinemaDAO.getCinemaById(id);
    }
}