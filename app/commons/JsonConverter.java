package commons;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonConverter<T> {

    private static Gson gson;

    private static Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public String serialize(T object) {
        return getGsonInstance().toJson(object);
    }

    public T deserialize(String json, Type type) {
        return getGsonInstance().fromJson(json, type);
    }

}
