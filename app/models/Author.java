package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@SQLDelete(sql = "Update author SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause = "is_deleted != 1")
public class Author extends MetaModel implements Comparable<Author> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new LinkedList<>();

    public Author(String name, Book... writtenBooks) {
        this.name = name;
        Collections.addAll(books, writtenBooks);
    }

    @Override
    public int compareTo(Author otherTag) {
        return name.compareTo(otherTag.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

}
