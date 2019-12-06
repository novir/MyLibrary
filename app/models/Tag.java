package models;

import dto.TagDto;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
@SQLDelete(sql = "Update tag SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause = "is_deleted != 1")
public class Tag extends MetaModel implements Comparable<Tag> {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    private Set<Book> books = new HashSet<>();

    public Tag(String name, Book... taggedBooks) {
        this.name = name;
        Collections.addAll(books, taggedBooks);
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void tagBook(Book book) {
        if (book != null) {
            books.add(book);
            book.getTags().add(this);
        }
    }

    @Override
    public int compareTo(Tag otherTag) {
        return name.compareTo(otherTag.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public TagDto toDto() {
        return new TagDto.TagDtoBuilder(this).build();
    }

}
