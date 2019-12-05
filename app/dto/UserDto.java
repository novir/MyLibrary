package dto;

import models.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto extends MetaDto {

    private String login;

    private String password;

    private String email;

    private Set<BookDto> books;

    private UserDto(UserDtoBuilder builder) {
        super(builder.id);
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

    public static class UserDtoBuilder {

        private Long id;

        private String login;

        private String password;

        private String email;

        private Set<BookDto> books = new HashSet<>();

        private User userModel;

        public UserDtoBuilder(String login, String password, String email) {
            this.login = login;
            this.password = password;
            this.email = email;
        }

        public UserDtoBuilder(User user) {
            userModel = user;
            id = user.getId();
            login = userModel.getLogin();
            password = userModel.getPassword();
            email = userModel.getEmail();
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
                    .map(book -> new BookDto.BookDtoBuilder(book).build())
                    .collect(Collectors.toSet());
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

}
