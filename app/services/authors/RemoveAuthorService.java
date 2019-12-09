package services.authors;

import dao.AuthorDao;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class RemoveAuthorService {

    public Optional<AuthorDto> execute(long id) {
        AuthorDao authorDao = new AuthorDao();
        Optional<Author> modelToDelete = authorDao.find(id);
        if (modelToDelete.isPresent()) {
            Author deletedModel = authorDao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
