package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Entity
@SQLDelete(sql="Update book SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Book extends Model {

    @Column(name="title")
    private String title;

    @Column(name="purchase_date")
    private Date purchaseDate;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deletedAt;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @ManyToOne
    private User owner;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="book_tag")
    private Set<Tag> tags;

    public Book(User owner, String title, Date purchaseDate, Tag... bookTags) {
        this.owner = owner;
        this.title = title;
        this.purchaseDate = purchaseDate;
        tags = new TreeSet<>();
        Collections.addAll(tags, bookTags);
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.toLocalDate();
    }

    public LocalDate getCreatedAt() {
        return createdAt.toLocalDate();
    }

    public LocalDate getUpdatedAt() {
        return updatedAt.toLocalDate();
    }

    public LocalDate getDeletedAt() {
        return deletedAt.toLocalDate();
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public User getOwner() {
        return owner;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        if (purchaseDate != null) {
            this.purchaseDate = Date.valueOf(purchaseDate);
        }
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
