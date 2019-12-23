package commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class JsonConverter<T> {

    private static Gson gson;

    private static Gson getGsonInstance() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .create();
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
