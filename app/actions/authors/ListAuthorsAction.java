package actions.authors;

import actions.AbstractListAction;
import dto.AuthorDto;
import services.authors.ListAuthorsService;

import java.util.List;

public class ListAuthorsAction extends AbstractListAction<AuthorDto> {

    @Override
    protected List<AuthorDto> run() {
        ListAuthorsService listAuthorsService = new ListAuthorsService();
        return listAuthorsService.execute();
    }

}
