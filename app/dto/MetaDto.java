package dto;

public abstract class MetaDto {

    private final Long id;

    MetaDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
