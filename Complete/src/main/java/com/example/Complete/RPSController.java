package com.example.Complete;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPSController {

    @RequestMapping(value = "/rps", method = RequestMethod.GET)
    public String rpsLanding(){
        return "To play a game of rock, paper or scissors please append /rps with your choice in the manner of /rps/rock , /rps/paper , /rps/scissor. " +
                "\n\r To see your result please append /rps with /result in this manner /rps/result";
    }

}
