package actions.authors;

import actions.AbstractCrudAction;
import dto.AuthorDto;
import services.authors.ShowAuthorService;

import java.util.Optional;

public class ShowAuthorAction extends AbstractCrudAction<AuthorDto> {

    @Override
    protected Optional<AuthorDto> run() {
        ShowAuthorService showAuthorService = new ShowAuthorService();
        return showAuthorService.execute(id);
    }
}
