public class Cinema {
    private Long id;
    private String name;
    private String location;

    public Cinema() {
    }

    public Cinema(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Cinema{id = " + id + ", name = " + name + ", location = " + location + "}";
    }
    // getters and setters

    public static class AdminService {
    }
}
