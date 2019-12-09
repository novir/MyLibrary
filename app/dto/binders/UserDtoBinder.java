package dto.binders;

import dto.UserDto;
import play.data.binding.Global;
import play.data.binding.TypeBinder;
import play.mvc.Http;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Global
public class UserDtoBinder implements TypeBinder<UserDto> {

    @Override
    public Object bind(String name, Annotation[] annotations, String value, Class actualClass, Type genericType)
            throws Exception {
        Map<String, String> userData = parseDataFromRequest(Http.Request.current(), name);
        UserDto user = new UserDto.UserDtoBuilder("", "", "").build();

        if (userData.containsKey("login")) {
            user.setLogin(userData.get("login"));
        }
        if (userData.containsKey("password")) {
            user.setPassword(userData.get("password"));
        }
        if (userData.containsKey("email")) {
            user.setEmail(userData.get("email"));
        }

        return user;
    }

    private Map<String, String> parseDataFromRequest(Http.Request request, String rootName) {
        String rootScope = rootName + ".";
        return request.params.data
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith(rootScope))
                .collect(
                        Collectors.toMap(
                            entry -> entry.getKey().replaceFirst(rootScope, ""),
                            entry -> String.join(",", entry.getValue())
                        )
                );
    }

}
