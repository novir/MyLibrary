package services.authors;

import dao.AuthorDao;
import dto.AuthorDto;
import models.Author;

public class CreateAuthorService {

    public AuthorDto execute(AuthorDto authorData) {
        AuthorDao authorDao = new AuthorDao();
        Author modelToPersist = authorData.toModel();
        Author persistedModel = authorDao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
