package commons;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.Author;

import java.lang.reflect.Type;

public class AuthorRelationSerializer implements JsonSerializer<Author> {

    @Override
    public JsonElement serialize(Author author, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("name", author.getName());
        return json;
    }
}
