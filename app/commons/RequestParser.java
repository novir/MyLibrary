package commons;

import play.mvc.Http;

import java.util.Map;
import java.util.stream.Collectors;

public class RequestParser {

    public static Map<String, String> parseDataFromRequest(Http.Request request, String rootName) {
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
