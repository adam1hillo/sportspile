package adamh.sportspile.domain.news;

import java.time.LocalDateTime;

public class News {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime dateAdded;
    private Integer disciplineId;
    private Integer userId;

    public News(Integer id, String title, String url, String description, LocalDateTime dateAdded, Integer disciplineId, Integer userId) {
        this(title, url, description, dateAdded, disciplineId, userId);
        this.id = id;
    }

    public News(String title, String url, String description, LocalDateTime dateAdded, Integer disciplineId, Integer userId) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateAdded = dateAdded;
        this.disciplineId = disciplineId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public Integer getUserId() {
        return userId;
    }
}
