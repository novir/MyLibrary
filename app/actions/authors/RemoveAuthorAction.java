package actions.authors;

import actions.AbstractCrudAction;
import dto.AuthorDto;
import services.authors.RemoveAuthorService;

import java.util.Optional;

public class RemoveAuthorAction extends AbstractCrudAction<AuthorDto> {

    @Override
    protected Optional<AuthorDto> run() {
        RemoveAuthorService removeAuthorService = new RemoveAuthorService();
        return removeAuthorService.execute(id);
    }
}
