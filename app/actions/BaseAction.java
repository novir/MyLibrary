package actions;

import com.google.gson.Gson;

public abstract class BaseAction<T> {

    private static Gson gson;

    private static Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    protected String getAsJson(T dto) {
        return getGsonInstance().toJson(dto);
    }

}
