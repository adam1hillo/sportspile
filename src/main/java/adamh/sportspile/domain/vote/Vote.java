package adamh.sportspile.domain.vote;

import java.time.LocalDateTime;

public class Vote {
    private Integer userId;
    private Integer newsId;
    private Type type;
    private LocalDateTime dateAdded;

    public Vote(Integer userId, Integer newsId, Type type, LocalDateTime dateAdded) {
        this.userId = userId;
        this.newsId = newsId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public enum Type {
        UP, DOWN;
    }
}
