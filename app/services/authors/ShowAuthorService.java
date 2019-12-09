package services.authors;

import dao.AuthorDao;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class ShowAuthorService {

    public Optional<AuthorDto> execute(long id) {
        AuthorDao authorDao = new AuthorDao();
        return authorDao.find(id).map(Author::toDto);
    }

}
