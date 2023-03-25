package com.taco_group.taco.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZakazController {

    @GetMapping("/zakaz")
    public String zakazMain(Model model) {
        return "zakaz";
    }

    @GetMapping("/FIO")
    public String zakazFIO(Model model) {
        return "FIO";
    }

    @GetMapping("/End")
    public String zakazEnd(Model model) {
        return "End";
    }
}
