import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private Long userId;
    private Long showtimeId;
    private LocalDateTime purchaseTime;
    private long cinemaId;
    private String seatNumber;
    private long movieId;

    public Ticket() {
    }

    public Ticket(Long id, Long userId, Long showtimeId, LocalDateTime purchaseTime) {
        this.id = id;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.purchaseTime = purchaseTime;
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
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     *
     * @return showtimeId
     */
    public Long getShowtimeId() {
        return showtimeId;
    }

    /**
     * 设置
     *
     * @param showtimeId
     */
    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    /**
     * 获取
     *
     * @return purchaseTime
     */
    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    /**
     * 设置
     *
     * @param purchaseTime
     */
    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String toString() {
        return "Ticket{id = " + id + ", userId = " + userId + ", showtimeId = " + showtimeId + ", purchaseTime = " + purchaseTime + "}";
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    // getters and setters
}
