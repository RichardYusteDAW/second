package fpmislata.bookstore.b_presentation.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LorenzoController {

    @GetMapping("/lorenzo")
    public String index() {
        return "index.html";
    }
}