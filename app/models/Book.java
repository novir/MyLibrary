package models;

import com.google.gson.annotations.JsonAdapter;
import commons.AuthorRelationSerializer;
import commons.TagRelationSerializer;
import commons.UserRelationSerializer;
import dto.BookDto;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity(name = "Book")
@Table(name = "book")
@SQLDelete(sql = "Update book SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause = "is_deleted != 1")
public class Book extends MetaModel {

    @Column(name = "title")
    private String title;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonAdapter(UserRelationSerializer.class)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id", nullable = true)
    @JsonAdapter(AuthorRelationSerializer.class)
    private Author author;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_tag",
                joinColumns = @JoinColumn(name = "tag_id"),
                inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonAdapter(TagRelationSerializer.class)
    private Set<Tag> tags = new TreeSet<>();

    public Book(User owner, String title, LocalDate purchaseDate, Tag... bookTags) {
        this(owner, null, title, purchaseDate, bookTags);
    }

    public Book(User owner, Author author, String title,
                LocalDate purchaseDate, Tag... bookTags) {
        this.owner = owner;
        this.author = author;
        this.title = title;
        this.purchaseDate = Date.valueOf(purchaseDate);
        Collections.addAll(tags, bookTags);
    }

    public Book(Book original) {
        title = original.title;
        purchaseDate = original.purchaseDate;
        owner = original.owner;
        author = original.author;
        tags.addAll(original.tags);
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

    public Author getAuthor() {
        return author;
    }

    public Set<Tag> getTags() {
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

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void addTag(Tag tag) {
        if (tag != null) {
            tags.add(tag);
            tag.getBooks().add(this);
        }
    }

    public BookDto toDto() {
        return new BookDto.BookDtoBuilder(this).build();
    }

    public void fillWith(Book other) {
        if (other.title != null) {
            this.title = other.title;
        }
        if (other.purchaseDate != null) {
            this.purchaseDate = other.purchaseDate;
        }
        if (other.owner != null) {
            this.owner = other.owner;
        }
        if (other.author != null) {
            this.author = other.author;
        }
        if (other.tags != null) {
            this.tags = other.tags;
        }
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
