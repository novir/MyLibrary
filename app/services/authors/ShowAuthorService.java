package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class ShowAuthorService {

    private final DaoInterface<Author> dao = new AuthorDao<>();

    public Optional<AuthorDto> execute(long id) {
        return dao.find(id).map(Author::toDto);
    }

}
