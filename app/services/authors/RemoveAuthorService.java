package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class RemoveAuthorService {

    public Optional<AuthorDto> execute(long id) {
        DaoInterface<Author> dao = new AuthorDao<>();
        Optional<Author> modelToDelete = dao.find(id);
        if (modelToDelete.isPresent()) {
            Author deletedModel = dao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
