public class Movie {
    private Long id;
    private String title;
    private String description;
    private int duration;

    public Movie() {
    }

    public Movie(Long id, String title, String description, int duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     *
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 设置
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "Movie{id = " + id + ", title = " + title + ", description = " + description + ", duration = " + duration + "}";
    }
    // getters and setters
}
