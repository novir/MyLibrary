package services.authors;

import dao.AuthorDao;
import dao.DaoInterface;
import dto.AuthorDto;
import models.Author;

import java.util.Optional;

public class UpdateAuthorService {

    private final DaoInterface<Author> dao = new AuthorDao<>();

    public Optional<AuthorDto> execute(long id, AuthorDto authorData) {
        Optional<Author> retrievedAuthor = dao.find(id);
        // retrievedAuthor.fillWith(authorData.toModel());
        return retrievedAuthor.map(this::updateAuthor);
    }

    private AuthorDto updateAuthor(Author author) {
        Author updatedModel = dao.save(author);
        return updatedModel.toDto();
    }

}
