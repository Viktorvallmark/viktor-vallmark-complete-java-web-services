package com.example.Complete;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ModelRPS {


    @RequestMapping(value = "/rps/{choice}", method = RequestMethod.GET)
    public String playGame(scoreBean scoreBean, @RequestParam String choice) {

        String[] rps = {"rock", "paper", "scissor"};

        var computerChoice = rps[new Random().nextInt(rps.length)];

        if(choice.equals("rock") || choice.equals("paper") || choice.equals("scissor")){
            System.out.println("Ok");
            switch (choice) {
                case "rock":
                    if (choice.equals(computerChoice)) {
                        scoreBean.addDraw();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! It is a draw!";
                    } else if (computerChoice.equals("paper")) {
                        scoreBean.addLoss();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! You lose this one!";
                    } else {
                        scoreBean.addWin();
                        return "You chose: " + choice + "and the computer chose: " + computerChoice +"! You win this one!";
                    }
                case "scissor":
                    if (computerChoice.equals("rock")) {
                        scoreBean.addLoss();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! You lose this one!";
                    } else if (computerChoice.equals("paper")) {
                        scoreBean.addWin();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! You win this one!";
                    } else {
                        scoreBean.addDraw();
                        return "You chose: " + choice + "and the computer chose: " + computerChoice +"! It is a draw!";
                    }
                case "paper":
                    if (computerChoice.equals("rock")) {
                        scoreBean.addWin();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! You win this one!";
                    } else if (computerChoice.equals("paper")) {
                        scoreBean.addDraw();
                        return "You chose: " + choice + "and computer chose: " + computerChoice +"! It is a draw!";
                    } else {
                        scoreBean.addLoss();
                        return "You chose: " + choice + "and the computer chose: " + computerChoice +"! You lose this one!";
                    }
            }
            return "Please play again!";
        }else{
            return "Please choose between: rock, paper or scissor! Remember the choice is case sensitive.";
        }

    }



    @RequestMapping(value = "/rps/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showResult(scoreBean scoreBean){
        String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
        return String.format(pattern, scoreBean.getWin(), scoreBean.getLoss(), scoreBean.getDraw());
    }

}
