package com.web_project.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "set");
        return "Home";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("a") double a,
                            @RequestParam("b") double b,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        return "calculator";
    }

    @GetMapping("/converter")
    public String converter() {
        return "converter";
    }

    @PostMapping("convert")
    public String convert(@RequestParam("value1") double value1,
                          @RequestParam("currency") String currency,
                          @RequestParam("currency2") String currency2,
                          Model model) {

        double result = 0.0;

        if (currency.equals("₽")) {
            if (currency2.equals("$")) {
                result = value1 * 0.011;
            } else if (currency2.equals("₩")) {
                result = value1 * 14;
            } else if (currency2.equals("¥")) {
                result = value1 * 1.5;
            } else if (currency2.equals("₽")) {
                result = value1;
            }
        } else if (currency.equals("¥")) {
            if (currency2.equals("₽")) {
                result = value1 * 1.5;
            } else if (currency2.equals("$")) {
                result = value1 * 0.0070;
            } else if (currency2.equals("₩")) {
                result = value1 * 9;
            } else if (currency2.equals("¥")) {
                result = value1;
            }
        } else if (currency.equals("₩")) {
            if (currency2.equals("$")) {
                result = value1 * 0.00075;
            } else if (currency2.equals("¥")) {
                result = value1 * 0.11;
            } else if (currency2.equals("₽")) {
                result = value1 * 0.0070;
            } else if (currency2.equals("₩")) {
                result = value1;
            }
        } else if (currency.equals("$")) {
            if (currency2.equals("₽")) {
                result = value1 * 93;
            } else if (currency2.equals("¥")) {
                result = value1 * 143;
            } else if (currency2.equals("₩")) {
                result = value1 * 1337.15;
            } else if (currency2.equals("$")) {
                result = value1;
            }
        }

        model.addAttribute("result", result);
        return "result";
    }
}
