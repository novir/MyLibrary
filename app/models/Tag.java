package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity
@SQLDelete(sql="Update tag SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Tag extends Model implements Comparable<Tag> {

    @Column(name="name")
    public String name;

    @Column(name="created_at")
    public Date createdAt;

    @Column(name="updated_at")
    public Date updatedAt;

    @Column(name="deleted_at")
    public Date deletedAt;

    @Column(name="is_deleted")
    public boolean isDeleted;

    @ManyToMany
    public Set<Book> books;

    public static Tag findOrCreateByName(String name, Book... taggedBooks) {
        Tag tag = Tag.find("byName", name).first();
        if(tag == null) {
            tag = new Tag(name, taggedBooks);
        }
        return tag;
    }

    public Tag(String name, Book... taggedBooks) {
        this.name = name;
        books = new HashSet<>();
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

}
