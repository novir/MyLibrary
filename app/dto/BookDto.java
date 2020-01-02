package dto;

import com.google.gson.annotations.JsonAdapter;
import commons.LocalDateSerializer;
import models.Author;
import models.Book;
import models.Tag;
import models.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDto extends BaseDto {

    private String title;

    @JsonAdapter(LocalDateSerializer.class)
    private LocalDate purchaseDate;

    private UserDto owner;

    private AuthorDto author;

    private Set<TagDto> tags;

    public BookDto(UserDto owner, String title, LocalDate purchaseDate) {
        this(owner, null, title, purchaseDate);
    }

    public BookDto(UserDto owner, AuthorDto author, String title, LocalDate purchaseDate) {
        this.owner = owner;
        this.author = author;
        this.title = title;
        this.purchaseDate = purchaseDate;
    }

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

    public UserDto getOwner() {
        return owner;
    }

    public Optional<AuthorDto> getAuthor() {
        return Optional.ofNullable(author);
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

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public void setTags(Set<TagDto> tags) {
        this.tags = tags;
    }

    @Override
    public Book toModel() {
        Author bookAuthor = getAuthor().map(AuthorDto::toModel).orElse(null);
        return new Book(owner.toModel(), bookAuthor, title, purchaseDate);
    }

    // Builder nested class
    public static class BookDtoBuilder {

        private Long id;

        private String title;

        private LocalDate purchaseDate;

        private UserDto owner;

        private AuthorDto author;

        private Set<TagDto> tags = new HashSet<>();

        private LocalDate createdAt;

        private LocalDate updatedAt;

        private LocalDate deletedAt;

        private Book bookModel;

        public BookDtoBuilder(Book book) {
            bookModel = book;
            id = bookModel.getId();
            title = bookModel.getTitle();
            purchaseDate = bookModel.getPurchaseDate();
            createdAt = bookModel.getCreatedAt().orElse(null);
            updatedAt = bookModel.getUpdatedAt().orElse(null);
            deletedAt = bookModel.getDeletedAt().orElse(null);
        }

        public BookDtoBuilder withOwner() {
            if (bookModel != null) {
                User model = bookModel.getUser();
                this.owner = model.toDto();
            }
            return this;
        }

        public BookDtoBuilder withAuthor() {
            if (bookModel != null) {
                Author model = bookModel.getAuthor();
                this.author = model.toDto();
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
