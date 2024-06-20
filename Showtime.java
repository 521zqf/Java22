import java.time.LocalDateTime;

public class Showtime {
    private Long id;
    private Long movieId;
    private Long cinemaId;
    private LocalDateTime showtime;

    public Showtime() {
    }

    public Showtime(Long id, Long movieId, Long cinemaId, LocalDateTime showtime) {
        this.id = id;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.showtime = showtime;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return movieId
     */
    public Long getMovieId() {
        return movieId;
    }

    /**
     * 设置
     *
     * @param movieId
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    /**
     * 获取
     *
     * @return cinemaId
     */
    public Long getCinemaId() {
        return cinemaId;
    }

    /**
     * 设置
     *
     * @param cinemaId
     */
    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * 获取
     *
     * @return showtime
     */
    public LocalDateTime getShowtime() {
        return showtime;
    }

    /**
     * 设置
     *
     * @param showtime
     */
    public void setShowtime(LocalDateTime showtime) {
        this.showtime = showtime;
    }

    public String toString() {
        return "Showtime{id = " + id + ", movieId = " + movieId + ", cinemaId = " + cinemaId + ", showtime = " + showtime + "}";
    }
    // getters and setters
}
