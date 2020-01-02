package services.books;

import dao.DaoInterface;
import dao.BookDao;
import dto.BookDto;
import models.Book;

import java.util.List;
import java.util.stream.Collectors;

public class ListBooksService {

    private final DaoInterface<Book> dao = new BookDao<>();

    public List<BookDto> execute() {
        return dao.findAll()
                .stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }

}
