package dto;

import java.time.LocalDate;
import java.util.Optional;

public abstract class BaseDto {

    private final Long id;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate deletedAt;

    private boolean isDeleted;

    BaseDto(Long id, LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        if (deletedAt != null) {
            isDeleted = true;
        }
    }

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
