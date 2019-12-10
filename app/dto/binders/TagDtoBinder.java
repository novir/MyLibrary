package dto.binders;

import commons.JsonConverter;
import dto.TagDto;
import play.data.binding.Global;
import play.data.binding.TypeBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Global
public class TagDtoBinder implements TypeBinder<TagDto> {

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType)
            throws Exception {
        // TODO Change new object creation to DI
        JsonConverter<TagDto> converter = new JsonConverter<>();
        return converter.deserialize(value, genericType);
    }
}
