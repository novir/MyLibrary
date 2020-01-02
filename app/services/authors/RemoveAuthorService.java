package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class RemoveAuthorService {

    private final DaoInterface<Author> dao = new AuthorDao<>();

    public Optional<AuthorDto> execute(long id) {
        Optional<Author> retrievedAuthor = dao.find(id);
        return retrievedAuthor.map(this::removeAuthor);
    }

    private AuthorDto removeAuthor(Author author) {
        Author deletedModel = dao.delete(author);
        return deletedModel.toDto();
    }

}
