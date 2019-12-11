package dto.binders;

import commons.JsonConverter;
import dto.BookDto;
import play.data.binding.Global;
import play.data.binding.TypeBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Global
public class BookDtoBinder implements TypeBinder<BookDto> {

    // TODO Change new object creation to DI
    private JsonConverter<BookDto> converter = new JsonConverter<>();

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType)
            throws Exception {
        return converter.deserialize(value, genericType);
    }
}
