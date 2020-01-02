package services.tags;

import dao.DaoInterface;
import dao.TagDao;
import dto.TagDto;
import models.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class ListTagsService {

    private final DaoInterface<Tag> dao = new TagDao<>();

    public List<TagDto> execute() {
        return dao.findAll()
                .stream()
                .map(Tag::toDto)
                .collect(Collectors.toList());
    }

}
