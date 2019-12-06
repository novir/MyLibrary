package actions;

import com.google.gson.Gson;

public abstract class AbstractAction<T> extends BaseAction {

    private static Gson gson;

    protected String getAsJson(T dto) {
        return getGsonInstance().toJson(dto);
    }

    private static Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }



}
