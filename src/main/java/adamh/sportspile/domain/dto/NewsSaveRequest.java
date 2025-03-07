package adamh.sportspile.domain.dto;

public class NewsSaveRequest {
    private String title;
    private String url;
    private String description;
    private Integer disciplineId;
    private String username;

    public NewsSaveRequest(String title, String url, String description, Integer disciplineId, String username) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.disciplineId = disciplineId;
        this.username = username;
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

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public String getUsername() {
        return username;
    }
}
