package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

public class Application extends Controller {

    @Before
    static void addDefaults() {
        renderArgs.put("appTitle", Play.configuration.getProperty("app.title"));
        renderArgs.put("appBaseline", Play.configuration.getProperty("app.baseline"));
    }

    public static void index() {
        render();
    }

}