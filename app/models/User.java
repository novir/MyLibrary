package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "owner")
@SQLDelete(sql="Update owner SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class User extends Model {

    @Column(name="login", unique=true)
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="email", unique=true)
    private String email;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="deleted_at")
    private Date deletedAt;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    private List<Book> books;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.books = new LinkedList<>();
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setLogin(String login) {
        if (login != null && !login.trim().isEmpty()) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("Login can't be empty.");
        }
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password can't be empty.");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email can't be empty.");
        }
    }
}
