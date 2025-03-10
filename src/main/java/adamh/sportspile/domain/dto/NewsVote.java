package adamh.sportspile.domain.dto;

public class NewsVote {
    private String username;
    private Integer newsId;
    private String type;

    public NewsVote(String username, Integer newsId, String type) {
        this.username = username;
        this.newsId = newsId;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public String getType() {
        return type;
    }
}
