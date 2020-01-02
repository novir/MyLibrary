package services.tags;

import dao.TagDao;
import dao.DaoInterface;
import dto.TagDto;
import models.Tag;

public class CreateTagService {

    private final DaoInterface<Tag> dao = new TagDao<>();

    public TagDto execute(TagDto tagData) {
        Tag modelToPersist = tagData.toModel();
        Tag persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
