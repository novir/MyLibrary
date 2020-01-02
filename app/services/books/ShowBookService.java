package services.books;

import dao.DaoInterface;
import dao.BookDao;
import dto.BookDto;
import models.Book;

import java.util.Optional;

public class ShowBookService {

    private final DaoInterface<Book> dao = new BookDao<>();

    public Optional<BookDto> execute(long id) {
        return dao.find(id).map(Book::toDto);
    }

}
