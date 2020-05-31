package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookController {

    @GetMapping("/book-create")
    public String create(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "book/create.html";
    }

    @GetMapping("/book-update")
    public String update(@RequestParam(name="isbn", required=true) String isbn, Model model) {
        final String uri = "http://127.0.0.1:8000/books/1";

        RestTemplate restTemplate = new RestTemplate();
        String book = restTemplate.getForObject(uri, String.class);
        return "book/update.html";
    }


    @GetMapping("/all-books")
    public String index(Model model) {

        final String uri = "http://127.0.0.1:8000/books";

        RestTemplate restTemplate = new RestTemplate();
        String books = restTemplate.getForObject(uri, String.class);

        model.addAttribute("books1", "{books : " + books + "}");
        model.addAttribute("books2", books);

        System.out.println("{books : " + books + "}");
        return "book/index.html";

    }
}
