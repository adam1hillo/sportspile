package adamh.sportspile.domain.news;

import java.time.LocalDateTime;

public class News {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private LocalDateTime dateAdded;
    private Integer discipline_id;

    public News(Integer id, String title, String url, String description, LocalDateTime dateAdded, Integer discipline_id) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.dateAdded = dateAdded;
        this.discipline_id = discipline_id;
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

    public Integer getDiscipline_id() {
        return discipline_id;
    }
}
