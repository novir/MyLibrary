package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity(name="User")
@Table(name="owner")
@SQLDelete(sql="Update owner SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class User extends MetaModel {

    @Column(name="login", unique=true, nullable=false)
    private String login;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    private List<Book> books;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.books = new LinkedList<>();
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

    public List<Book> getBooks() {
        return books;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
