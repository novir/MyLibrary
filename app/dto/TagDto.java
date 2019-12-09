package dto;

import models.Book;
import models.Tag;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TagDto extends BaseDto {

    private String name;

    private Set<BookDto> books;

    private TagDto(TagDtoBuilder builder) {
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
    public Object toModel() {
        return new Tag(name);
    }

    public static class TagDtoBuilder {

        private Long id;

        private String name;

        private Set<BookDto> books = new HashSet<>();

        private LocalDate createdAt;

        private LocalDate updatedAt;

        private LocalDate deletedAt;

        private Tag tagModel;

        public TagDtoBuilder(String name) {
            this.name = name;
        }

        public TagDtoBuilder(Tag tag) {
            tagModel = tag;
            id = tagModel.getId();
            name = tagModel.getName();
            createdAt = tagModel.getCreatedAt().orElse(null);
            updatedAt = tagModel.getUpdatedAt().orElse(null);
            deletedAt = tagModel.getDeletedAt().orElse(null);
        }

        public TagDtoBuilder withBooks() {
            if (tagModel != null) {
                books = getTaggedBooks();
            }
            return this;
        }

        private Set<BookDto> getTaggedBooks() {
            return tagModel.getBooks()
                    .stream()
                    .map(Book::toDto)
                    .collect(Collectors.toSet());
        }

        public TagDto build() {
            return new TagDto(this);
        }
    }

}
