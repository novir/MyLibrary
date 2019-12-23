package commons;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.Tag;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

public class TagRelationSerializer implements JsonSerializer<Collection<Tag>> {

    @Override
    public JsonElement serialize(Collection<Tag> bag, Type type, JsonSerializationContext context) {
        JsonArray json = new JsonArray();
        for (Tag tag : bag) {
            json.add(tag.toString());
        }
        return json;
    }
}
