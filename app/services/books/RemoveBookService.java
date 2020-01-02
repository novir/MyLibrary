package services.books;

import dao.DaoInterface;
import dao.BookDao;
import dto.BookDto;
import models.Book;

import java.util.Optional;

public class RemoveBookService {

    private final DaoInterface<Book> dao = new BookDao<>();

    public Optional<BookDto> execute(long id) {
        Optional<Book> modelToDelete = dao.find(id);
        if (modelToDelete.isPresent()) {
            Book deletedModel = dao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
