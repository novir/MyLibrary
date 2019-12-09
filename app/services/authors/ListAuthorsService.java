package services.authors;

import dao.AuthorDao;
import dto.AuthorDto;
import models.Author;

import java.util.List;
import java.util.stream.Collectors;

public class ListAuthorsService {

    public List<AuthorDto> execute() {
        AuthorDao authorDao = new AuthorDao();
        return authorDao.findAll()
                .stream()
                .map(Author::toDto)
                .collect(Collectors.toList());
    }

}
