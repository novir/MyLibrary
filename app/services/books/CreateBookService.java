package services.books;

import dao.DaoInterface;
import dao.BookDao;
import dto.BookDto;
import models.Book;

public class CreateBookService {

    private final DaoInterface<Book> dao = new BookDao<>();

    public BookDto execute(BookDto bookData) {
        Book modelToPersist = bookData.toModel();
        Book persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
