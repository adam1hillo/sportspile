package adamh.sportspile.domain.dto;

public class DisciplineName {

    private Integer id;
    private String name;

    public DisciplineName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
