package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;

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

    public Book(User owner, String title, Date purchaseDate) {
        this.owner = owner;
        this.title = title;
        this.purchaseDate = purchaseDate;
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }

}
