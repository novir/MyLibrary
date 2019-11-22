package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@SQLDelete(sql="Update book SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Book extends Model {

    @Column(name="title")
    public String title;

    @Column(name="purchase_date")
    public Date purchaseDate;

    @Column(name="created_at")
    public Date createdAt;

    @Column(name="updated_at")
    public Date updatedAt;

    @Column(name="deleted_at")
    public Date deletedAt;

    @Column(name="is_deleted")
    public boolean isDeleted;

    @ManyToOne
    public User owner;

    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Tag> tags;

    public Book(User owner, String title, Date purchaseDate, Tag... bookTags) {
        this.owner = owner;
        this.title = title;
        this.purchaseDate = purchaseDate;
        tags = new TreeSet<>();
        Collections.addAll(tags, bookTags);
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }

    public Book tagItWith(String name) {
        tags.add(Tag.findOrCreateByName(name));
        return this;
    }



}
