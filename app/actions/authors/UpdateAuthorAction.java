package actions.authors;

import actions.AbstractCrudAction;
import dto.AuthorDto;
import services.authors.UpdateAuthorService;

import java.util.Optional;

public class UpdateAuthorAction extends AbstractCrudAction<AuthorDto> {

    @Override
    protected Optional<AuthorDto> run() {
        UpdateAuthorService updateAuthorService = new UpdateAuthorService();
        return updateAuthorService.execute(id, dto);
    }

}