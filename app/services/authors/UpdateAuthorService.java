package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class UpdateAuthorService {

    public Optional<AuthorDto> execute(long id, AuthorDto authorData) {
        DaoInterface<Author> dao = new AuthorDao<>();
        Optional<Author> modelToUpdate = dao.find(id);
        if (modelToUpdate.isPresent()) {
            Author author = modelToUpdate.get();
            author.fillWith(authorData.toModel());
            Author updatedModel = dao.save(author);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }


}
