package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dice(){
        return "rolldice";
    }

    @GetMapping("/roll-dice/{num}")
    public String diceRoll(@PathVariable int num, Model model){
        int rand_int = ThreadLocalRandom.current().nextInt(1,6+1);
        model.addAttribute("dice",num);
        model.addAttribute("result",rand_int);
        if(num == rand_int){
            model.addAttribute("match","IT MATCHED!");
        }else{
            model.addAttribute("match","The numbers did not match.");
        }
        return "rolldice" ;
    }

}
