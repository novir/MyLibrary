package dto;

import models.Book;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDto extends MetaDto {

    private String title;

    private LocalDate purchaseDate;

    private UserDto owner;

//    private AuthorDto author;
//
//    private Set<TagDto> tags;

    private BookDto(BookDtoBuilder builder) {
        super(builder.id);
        title = builder.title;
        purchaseDate = builder.purchaseDate;
        owner = builder.owner;
//        author = builder.author;
//        tags = builder.tags;
    }

    public static class BookDtoBuilder {

        private Long id;

        private String title;

        private LocalDate purchaseDate;

        private UserDto owner;

//        private AuthorDto author;
//
//        private Set<TagDto> tags;

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
        }

//        public BookDtoBuilder withBooks() {
//            if (bookModel != null) {
//                books = bookModel.getBooks()
//                        .stream()
//                        .map(book -> {
//
//                        })
//                        .collect(Collectors.toList());
//            }
//            return this;
//        }

        public BookDto build() {
            return new BookDto(this);
        }
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

//    public AuthorDto getAuthor() {
//        return author;
//    }
//
//    public Set<TagDto> getTags() {
//        return tags;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setUser(UserDto user) {
        this.owner = user;
    }

//    public void setAuthor(AuthorDto author) {
//        this.author = author;
//    }

}
