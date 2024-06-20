import java.util.List;

public class MovieService {
    private MovieDAO movieDAO = new MovieDAO();

    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public Movie getMovieById(Long id) {
        return movieDAO.getMovieById(id);
    }

    public void saveMovie(Movie movie) {
        movieDAO.saveMovie(movie);
    }

    public void deleteMovie(Long id) {
        movieDAO.deleteMovie(id);
    }
}