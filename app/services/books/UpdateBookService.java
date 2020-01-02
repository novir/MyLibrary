package services.books;

import dao.DaoInterface;
import dao.BookDao;
import dto.BookDto;
import models.Book;

import java.util.Optional;

public class UpdateBookService {

    private final DaoInterface<Book> dao = new BookDao<>();

    public Optional<BookDto> execute(long id, BookDto bookData) {
        Optional<Book> modelToUpdate = dao.find(id);
        if (modelToUpdate.isPresent()) {
            Book book = modelToUpdate.get();
            book.fillWith(bookData.toModel());
            Book updatedModel = dao.save(book);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }


}
