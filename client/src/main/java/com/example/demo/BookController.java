package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookController {

    @GetMapping("/book/create")
    public String create() {
        return "book/create.html";
    }

    @GetMapping("/book/update")
    public String update(@RequestParam(name="isbn", required=true) String isbn, Model model) {
        final String uri = "http://127.0.0.1:8080/books/" + isbn;

        RestTemplate restTemplate = new RestTemplate();
        String book = restTemplate.getForObject(uri, String.class);
        model.addAttribute("book", book);
        return "book/update.html";
    }


    @GetMapping("/books")
    public String index(Model model) {

        final String uri = "http://127.0.0.1:8080/books";

        RestTemplate restTemplate = new RestTemplate();
        String books = restTemplate.getForObject(uri, String.class);

        model.addAttribute("books", books);

        return "book/index.html";

    }
}
