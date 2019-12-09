package services.authors;

import dao.AuthorDao;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class UpdateAuthorService {

    public Optional<AuthorDto> execute(long id, AuthorDto authorData) {
        AuthorDao authorDao = new AuthorDao();
        Optional<Author> modelToUpdate = authorDao.find(id);
        if (modelToUpdate.isPresent()) {
            Author author = modelToUpdate.get();
            author.fillWith(authorData.toModel());
            Author updatedModel = authorDao.save(author);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }


}
