package dto;

import com.google.gson.annotations.JsonAdapter;
import commons.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Optional;

public abstract class BaseDto<T> {

    private final Long id;

    @JsonAdapter(LocalDateSerializer.class)
    private final LocalDate createdAt;

    @JsonAdapter(LocalDateSerializer.class)
    private final LocalDate updatedAt;

    @JsonAdapter(LocalDateSerializer.class)
    private final LocalDate deletedAt;

    private final boolean isDeleted;

    BaseDto() {
        id = null;
        createdAt = null;
        updatedAt = null;
        deletedAt = null;
        isDeleted = false;
    }

    BaseDto(Long id, LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        isDeleted = (deletedAt != null);
    }

    public abstract T toModel();

    public Long getId() {
        return id;
    }

    public Optional<LocalDate> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public Optional<LocalDate> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public Optional<LocalDate> getDeletedAt() {
        return Optional.ofNullable(deletedAt);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

}
