package edu.escuelaing.arsw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    @RequestMapping("/")
    public String index(Model model) {
        CalculatorResult calculatorResult = CalculatorResult.getInstance();
        model.addAttribute("result", calculatorResult.getResult());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number") double number, @RequestParam("operation") String operation, Model model) {
        CalculatorResult calculatorResult = CalculatorResult.getInstance();
        try {
            switch (operation) {
                case "+":
                    calculatorResult.add(number);
                    break;
                case "-":
                    calculatorResult.subtract(number);
                    break;
                case "*":
                    calculatorResult.multiply(number);
                    break;
                case "/":
                    calculatorResult.divide(number);
                    break;
                case "AC":
                    calculatorResult.clear();
                    break;
            }
        } catch (ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("result", calculatorResult.getResult());
        return "calculate";
    }
}
