package dto;

import models.Book;
import models.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto extends BaseDto<User> {

    private String login;

    private String password;

    private String email;

    private Set<BookDto> books;

    public UserDto(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private UserDto(UserDtoBuilder builder) {
        super(builder.id, builder.createdAt, builder.updatedAt, builder.deletedAt);
        login = builder.login;
        password = builder.password;
        email = builder.email;
        books = builder.books;
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

    public Set<BookDto> getBooks() {
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

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    public User toModel() {
        return new User(login, password, email);
    }

    public static class UserDtoBuilder {

        private Long id;

        private String login;

        private String password;

        private String email;

        private Set<BookDto> books = new HashSet<>();

        private LocalDate createdAt;

        private LocalDate updatedAt;

        private LocalDate deletedAt;

        private User userModel;

        public UserDtoBuilder(User user) {
            userModel = user;
            id = userModel.getId();
            login = userModel.getLogin();
            password = userModel.getPassword();
            email = userModel.getEmail();
            createdAt = userModel.getCreatedAt().orElse(null);
            updatedAt = userModel.getUpdatedAt().orElse(null);
            deletedAt = userModel.getDeletedAt().orElse(null);
        }

        public UserDtoBuilder withBooks() {
            if (userModel != null) {
                books = getUserBooks();
            }
            return this;
        }

        private Set<BookDto> getUserBooks() {
            return userModel.getBooks()
                    .stream()
                    .map(Book::toDto)
                    .collect(Collectors.toSet());
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

}
