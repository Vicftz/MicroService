package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ReaderController {

    @GetMapping("/reader/create")
    public String create() {
        return "reader/create.html";
    }

    @GetMapping("/reader/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        final String uri = "http://127.0.0.1:8081/readers/" + id;

        RestTemplate restTemplate = new RestTemplate();
        String reader = restTemplate.getForObject(uri, String.class);
        model.addAttribute("reader", reader);
        return "reader/update.html";
    }


    @GetMapping("/readers")
    public String index(Model model) {

        final String uri = "http://127.0.0.1:8081/readers";

        RestTemplate restTemplate = new RestTemplate();
        String readers = restTemplate.getForObject(uri, String.class);

        model.addAttribute("readers", readers);
        return "reader/index.html";

    }
}
