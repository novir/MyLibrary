package models;

import dto.AuthorDto;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
@SQLDelete(sql = "Update author SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause = "is_deleted != 1")
public class Author extends MetaModel implements Comparable<Author> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private Set<Book> books = new HashSet<>();

    public Author(String name, Book... writtenBooks) {
        this.name = name;
        Collections.addAll(books, writtenBooks);
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    @Override
    public int compareTo(Author otherTag) {
        return name.compareTo(otherTag.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public AuthorDto toDto() {
        return new AuthorDto.AuthorDtoBuilder(this).build();
    }

}
