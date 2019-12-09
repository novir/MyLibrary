package actions.authors;

import actions.AbstractCrudAction;
import dto.AuthorDto;
import services.authors.CreateAuthorService;

import java.util.Optional;

public class CreateAuthorAction extends AbstractCrudAction<AuthorDto> {

    @Override
    protected Optional<AuthorDto> run() {
        CreateAuthorService createAuthorService = new CreateAuthorService();
        return Optional.ofNullable(createAuthorService.execute(dto));
    }

}