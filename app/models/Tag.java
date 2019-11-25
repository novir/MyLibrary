package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity
@SQLDelete(sql="Update tag SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Tag extends Model implements Comparable<Tag> {

    @Column(name="name")
    private String name;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deletedAt;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="book_tag")
    private List<Book> books;

    public Tag(String name, Book... taggedBooks) {
        this.name = name;
        books = new LinkedList<>();
        Collections.addAll(books, taggedBooks);
        createdAt = Date.valueOf(LocalDate.now());
        updatedAt = Date.valueOf(LocalDate.now());
    }

    @Override
    public int compareTo(Tag otherTag) {
        return name.compareTo(otherTag.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
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

    public List<Book> getBooks() {
        return books;
    }


}
