package Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RangeController{
    @PostMapping("/range")
    public int home(@RequestParam int num1, @RequestParam int num2) {
        Random random = new Random();
        return random.nextInt(num2 - num1 + 1) + num1;
    }
}
// POST /range?num1=10&num2=20 HTTP/1.1
