package com.example.Complete;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WelcomeController implements ErrorController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String root(){
        String index = "";
        index += "<html><head><title>This is my api</title></head>";
        index += "<body>";
        index += "<h4>this is all the methods of this API</h4>";
        index += "<ul>";
        index += "<li><a href=\"/calculator/calcMethod\">Calculator where calcMethod has calculation methods of addition, subtraction and multiplication</a></li> ";
        index += "<li><a href=\"/rps\">Rock, paper scissor game where you can play a game of rock paper scissors against the computer.</a></li>";
        index += "<li><a href=\"/csvreader\">Reads csv-files and gives JSON-structured output.</a></li>";
        index += "<li><a href=\"/img\">Shows random pictures.</a></li>";
        index += "</ul>";
        index += "</body></html>";
        return index;

    }


    @RequestMapping(value = "/errorOccurred", method = RequestMethod.GET)
    public String Happenings(HttpServletResponse response, HttpServletRequest request){

        return "Something went wrong";
    }

}
