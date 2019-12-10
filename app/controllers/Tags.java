package controllers;

import models.Tag;
import play.mvc.Controller;

import java.util.List;

public class Tags extends Controller {

    public static void index() {
        List<Tag> tags = Tag.findAll();
        renderJSON(tags);
    }
}
