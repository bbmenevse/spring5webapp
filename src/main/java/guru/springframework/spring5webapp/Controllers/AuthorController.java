package guru.springframework.spring5webapp.Controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    // This is where we name the url that will be typed on to enter webpage
    @RequestMapping("/authors")
    private String getAuthors(Model model)
    {
        model.addAttribute("authors",authorRepository.findAll());
        model.addAttribute("msg","Welcome to my page");
        return "authors/list";

    }


}
