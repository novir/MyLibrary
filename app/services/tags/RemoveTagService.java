package services.tags;

import dao.DaoInterface;
import dao.TagDao;
import dto.TagDto;
import models.Tag;

import java.util.Optional;

public class RemoveTagService {

    private final DaoInterface<Tag> dao = new TagDao<>();

    public Optional<TagDto> execute(long id) {
        Optional<Tag> modelToDelete = dao.find(id);
        if (modelToDelete.isPresent()) {
            Tag deletedModel = dao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
