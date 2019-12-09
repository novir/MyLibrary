package dto.binders;

import commons.RequestParser;
import dto.AuthorDto;
import play.data.binding.Global;
import play.data.binding.TypeBinder;
import play.mvc.Http;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

@Global
public class AuthorDtoBinder implements TypeBinder<AuthorDto> {

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType)
            throws Exception {
        Map<String, String> authorData = RequestParser.parseDataFromRequest(Http.Request.current(), name);
        AuthorDto author = new AuthorDto.AuthorDtoBuilder("").build();

        if (authorData.containsKey("name")) {
            author.setName(authorData.get("name"));
        }

        return author;
    }

}
