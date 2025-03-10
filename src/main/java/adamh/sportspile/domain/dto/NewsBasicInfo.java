package adamh.sportspile.domain.dto;

import java.time.LocalDateTime;

public class NewsBasicInfo {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime dateAdded;

    public NewsBasicInfo(Integer id, String title, String url, String description, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
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
}
