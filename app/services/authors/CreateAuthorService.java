package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

public class CreateAuthorService {

    private final DaoInterface<Author> dao = new AuthorDao<>();

    public AuthorDto execute(AuthorDto authorData) {
        Author modelToPersist = authorData.toModel();
        Author persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
