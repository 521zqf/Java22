public class Admin {
    private Long id;
    private String username;
    private String password;
    private Long cinemaId;

    public Admin() {
    }

    public Admin(Long id, String username, String password, Long cinemaId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cinemaId = cinemaId;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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

    public String toString() {
        return "Admin{id = " + id + ", username = " + username + ", password = " + password + ", cinemaId = " + cinemaId + "}";
    }
    // getters and setters
}

