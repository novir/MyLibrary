package models;

import dto.UserDto;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "User")
@Table(name = "owner")
@SQLDelete(sql = "Update owner SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause = "is_deleted != 1")
public class User extends MetaModel {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Book> books = new LinkedList<>();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
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

    public void addBook(Book book) {
        books.add(book);
        book.setUser(this);
    }

    public void fillWith(User other) {
        if (other.login != null) {
            this.login = other.login;
        }
        if (other.password != null) {
            this.password = other.password;
        }
        if (other.email != null) {
            this.email = other.email;
        }
        if (other.books != null) {
            this.books = other.books;
        }
    }

    public UserDto toDto() {
        return new UserDto.UserDtoBuilder(this).build();
    }

    @Override
    public String toString() {
        return getLogin();
    }

}
