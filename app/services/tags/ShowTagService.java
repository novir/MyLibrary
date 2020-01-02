package services.tags;

import dao.DaoInterface;
import dao.TagDao;
import dto.TagDto;
import models.Tag;

import java.util.Optional;

public class ShowTagService {

    private final DaoInterface<Tag> dao = new TagDao<>();

    public Optional<TagDto> execute(long id) {
        return dao.find(id).map(Tag::toDto);
    }

}
