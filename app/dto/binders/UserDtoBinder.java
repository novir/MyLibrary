package dto.binders;

import dto.UserDto;
import play.data.binding.Global;
import play.data.binding.TypeBinder;
import play.mvc.Http;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;

@Global
public class UserDtoBinder implements TypeBinder<UserDto> {

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType)
            throws Exception {
        Map<String, String[]> data = Http.Request.current().params.data;
        String login = data.get(name + "." + "login")[0];
        String password = data.get(name + "." + "password")[0];
        String email = data.get(name + "." + "email")[0];
        return new UserDto.UserDtoBuilder(login, password, email).build();
    }
}
