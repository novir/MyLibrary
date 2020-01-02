package services.tags;

import dao.DaoInterface;
import dao.TagDao;
import dto.TagDto;
import models.Tag;

import java.util.Optional;

public class UpdateTagService {

    private final DaoInterface<Tag> dao = new TagDao<>();

    public Optional<TagDto> execute(long id, TagDto tagData) {
        Optional<Tag> modelToUpdate = dao.find(id);
        if (modelToUpdate.isPresent()) {
            Tag tag = modelToUpdate.get();
            tag.fillWith(tagData.toModel());
            Tag updatedModel = dao.save(tag);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }

}
