package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

public class CreateAuthorService {

    public AuthorDto execute(AuthorDto authorData) {
        DaoInterface<Author> dao = new AuthorDao<>();
        Author modelToPersist = authorData.toModel();
        Author persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
