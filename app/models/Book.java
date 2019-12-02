package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity(name="Book")
@Table(name="book")
@SQLDelete(sql="Update book SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Book extends MetaModel {

    @Column(name="title")
    private String title;

    @Column(name="purchase_date")
    private Date purchaseDate;

    @ManyToOne
    private User owner;

    @ManyToOne
    private Author author;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="book_tag", joinColumns=@JoinColumn(name="tag_id"), inverseJoinColumns=@JoinColumn(name="book_id"))
    private List<Tag> tags;

    public Book(User user, String title, LocalDate purchaseDate, Tag... bookTags) {
        this.owner = user;
        this.title = title;
        this.purchaseDate = Date.valueOf(purchaseDate);
        tags = new LinkedList<>();
        Collections.addAll(tags, bookTags);
    }

    public Book(Book otherBook) {
        this.title = otherBook.title;

    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.toLocalDate();
    }

    public User getUser() {
        return owner;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = Date.valueOf(purchaseDate);
    }

    public void setUser(User user) {
        this.owner = user;
    }
}
