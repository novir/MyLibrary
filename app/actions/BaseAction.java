package actions;

import commons.JsonConverter;

public abstract class BaseAction<T> {

    protected String getAsJson(T dto) {
        // TODO Change new object creation to DI
        JsonConverter<T> converter = new JsonConverter<>();
        return converter.serialize(dto);
    }

}
