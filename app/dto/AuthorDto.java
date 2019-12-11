package dto;

import models.Author;
import models.Book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorDto extends BaseDto<Author> {

    private String name;

    private Set<BookDto> books;

    public AuthorDto(String name) {
        this.name = name;
    }

    private AuthorDto(AuthorDtoBuilder builder) {
        super(builder.id, builder.createdAt, builder.updatedAt, builder.deletedAt);
        name = builder.name;
        books = builder.books;
    }

    public String getName() {
        return name;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    @Override
    public Author toModel() {
        return new Author(name);
    }

    // Builder nested class
    public static class AuthorDtoBuilder {

        private Long id;

        private String name;

        private Set<BookDto> books = new HashSet<>();

        private LocalDate createdAt;

        private LocalDate updatedAt;

        private LocalDate deletedAt;

        private Author authorModel;

        public AuthorDtoBuilder(Author author) {
            authorModel = author;
            id = authorModel.getId();
            name = authorModel.getName();
            createdAt = authorModel.getCreatedAt().orElse(null);
            updatedAt = authorModel.getUpdatedAt().orElse(null);
            deletedAt = authorModel.getDeletedAt().orElse(null);
        }

        public AuthorDtoBuilder withBooks() {
            if (authorModel != null) {
                books = retrieveAuthorBooks();
            }
            return this;
        }

        private Set<BookDto> retrieveAuthorBooks() {
            return authorModel.getBooks()
                    .stream()
                    .map(Book::toDto)
                    .collect(Collectors.toSet());
        }

        public AuthorDto build() {
            return new AuthorDto(this);
        }
    }
}
