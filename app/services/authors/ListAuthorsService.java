package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.List;
import java.util.stream.Collectors;

public class ListAuthorsService {

    private final DaoInterface<Author> dao = new AuthorDao<>();

    public List<AuthorDto> execute() {
        return dao.findAll()
                .stream()
                .map(Author::toDto)
                .collect(Collectors.toList());
    }

}
