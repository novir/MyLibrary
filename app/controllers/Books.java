package controllers;

import models.Book;
import play.mvc.Controller;

import java.util.List;

public class Books extends Controller {

    public static void index() {
        List<Book> books = Book.findAll();
        renderJSON(books);
    }

}
