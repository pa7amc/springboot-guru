package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/books_list")
    public String getBooks(Model model){
        //we are going to add the attribute called Books and we're going to get execute book repository which is going to give us a list of books.

        /*Now this model is going to get return back to our view layer and it's going to have an attribute books and a list of books on that and then we'll be able to utilize that net value inside of our view layer to apply the necessary view that we're going to be returning back to the client.*/

        model.addAttribute("books", bookRepo.findAll());

        return "list_books";
    }

}
