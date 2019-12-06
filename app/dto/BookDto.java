package dto;

import models.Author;
import models.Book;
import models.Tag;
import models.User;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDto extends BaseDto {

    private String title;

    private LocalDate purchaseDate;

    private UserDto owner;

    private AuthorDto author;

    private Set<TagDto> tags;

    private BookDto(BookDtoBuilder builder) {
        super(builder.id, builder.createdAt, builder.updatedAt, builder.deletedAt);
        title = builder.title;
        purchaseDate = builder.purchaseDate;
        owner = builder.owner;
        author = builder.author;
        tags = builder.tags;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public UserDto getUser() {
        return owner;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public Set<TagDto> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setUser(UserDto user) {
        this.owner = user;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public static class BookDtoBuilder {

        private Long id;

        private String title;

        private LocalDate purchaseDate;

        private UserDto owner;

        private AuthorDto author;

        private Set<TagDto> tags;

        private LocalDate createdAt;

        private LocalDate updatedAt;

        private LocalDate deletedAt;

        private Book bookModel;

        public BookDtoBuilder(UserDto owner, String title, LocalDate purchaseDate) {
            this.owner = owner;
            this.title = title;
            this.purchaseDate = purchaseDate;
        }

        public BookDtoBuilder(Book book) {
            bookModel = book;
            title = bookModel.getTitle();
            purchaseDate = bookModel.getPurchaseDate();
            createdAt = bookModel.getCreatedAt().orElse(null);
            updatedAt = bookModel.getUpdatedAt().orElse(null);
            deletedAt = bookModel.getDeletedAt().orElse(null);
        }

        public BookDtoBuilder withOwner() {
            if (bookModel != null) {
                User user = bookModel.getUser();
                this.owner = user.toDto();
            }
            return this;
        }

        public BookDtoBuilder withAuthor() {
            if (bookModel != null) {
                Author author = bookModel.getAuthor();
                this.author = author.toDto();
            }
            return this;
        }

        public BookDtoBuilder withTags() {
            if (bookModel != null) {
                tags = bookModel.getTags()
                        .stream()
                        .map(Tag::toDto)
                        .collect(Collectors.toSet());
            }
            return this;
        }

        public BookDto build() {
            return new BookDto(this);
        }
    }

}
