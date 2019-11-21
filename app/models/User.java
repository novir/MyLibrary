package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
@SQLDelete(sql="Update owner SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class User extends Model {

    @Column(name="login", unique=true)
    public String login;

    @Column(name="password")
    public String password;

    @Column(name="email", unique=true)
    public String email;

    @Column(name="created_at")
    public Date createdAt;

    @Column(name="updated_at")
    public Date updatedAt;

    @Column(name="deleted_at")
    public Date deletedAt;

    @Column(name="is_deleted")
    public boolean isDeleted;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    public List<Book> books;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
        this.books = new ArrayList<>();
    }

}
