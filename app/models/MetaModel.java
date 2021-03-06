package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@MappedSuperclass
public abstract class MetaModel extends Model {

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deletedAt;

    @Column(name="is_deleted")
    private boolean isDeleted;

    public Optional<LocalDate> getCreatedAt() {
        return Optional.ofNullable(createdAt).map(Date::toLocalDate);
    }

    public Optional<LocalDate> getUpdatedAt() {
        return Optional.ofNullable(updatedAt).map(Date::toLocalDate);
    }

    public Optional<LocalDate> getDeletedAt() {
        return Optional.ofNullable(deletedAt).map(Date::toLocalDate);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = Date.valueOf(LocalDate.now());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Date.valueOf(LocalDate.now());
    }

}
