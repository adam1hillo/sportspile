package adamh.sportspile.domain.discipline;

public class Discipline {

    private Integer id;
    private String name;
    private String description;

    public Discipline(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
