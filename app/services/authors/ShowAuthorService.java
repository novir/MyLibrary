package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class ShowAuthorService {

    public Optional<AuthorDto> execute(long id) {
        DaoInterface<Author> dao = new AuthorDao<>();
        return dao.find(id).map(Author::toDto);
    }

}
