package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dice(){
        return "rolldice";
    }

//    @GetMapping("/roll-dice/{num}")
//    public String diceRoll(@PathVariable int num, Model model){
//        int rand_int = ThreadLocalRandom.current().nextInt(1,6+1);
//        model.addAttribute("dice",num);
//        model.addAttribute("result",rand_int);
//        if(num == rand_int){
//            model.addAttribute("match","IT MATCHED!");
//        }else{
//            model.addAttribute("match","The numbers did not match.");
//        }
//        return "rolldice" ;
//    }
    @GetMapping("/roll-dice/{num}")
    public String advancedDiceRoll(@PathVariable int num, Model model){
        int rand_int1 = ThreadLocalRandom.current().nextInt(1,6+1);
        int rand_int2 = ThreadLocalRandom.current().nextInt(1,6+1);
        int rand_int3 = ThreadLocalRandom.current().nextInt(1,6+1);
        int rand_int4 = ThreadLocalRandom.current().nextInt(1,6+1);
        int rand_int5 = ThreadLocalRandom.current().nextInt(1,6+1);
        List<Integer> diceRolls = new ArrayList<>();
        diceRolls.add(rand_int1);
        diceRolls.add(rand_int2);
        diceRolls.add(rand_int3);
        diceRolls.add(rand_int4);
        diceRolls.add(rand_int5);

        model.addAttribute("dice",num);
        model.addAttribute("result",diceRolls);
        int bucket = 0;
        for(var i = 0; i < diceRolls.size(); i++) {
            if (num == diceRolls.get(i)) {
                bucket++;
//                model.addAttribute("match", "IT MATCHED!");
            } else {
//                model.addAttribute("match", "The numbers did not match.");
            }
        }
                        model.addAttribute("match", bucket);

        return "rolldice" ;
    }

}