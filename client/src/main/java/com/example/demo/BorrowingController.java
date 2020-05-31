package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BorrowingController {

    @GetMapping("/reservations")
    public String borrowings(Model model) {
        final String uri = "http://127.0.0.1:8080/borrowings";

        RestTemplate restTemplate = new RestTemplate();
        String borrownings = restTemplate.getForObject(uri, String.class);

        model.addAttribute("borrownings", borrownings);
        return "borrowing/index.html";
    }

    @GetMapping("/nouvelle-reservation")
    public String newBorrow() {
        return "borrowing/create.html";
    }

    @GetMapping("/retours")
    public String backBorrow(Model model) {
        final String uri = "http://127.0.0.1:8080/returnings";

        RestTemplate restTemplate = new RestTemplate();
        String returnings = restTemplate.getForObject(uri, String.class);

        model.addAttribute("returnings", returnings);
        return "borrowing/back.html";
    }
}
