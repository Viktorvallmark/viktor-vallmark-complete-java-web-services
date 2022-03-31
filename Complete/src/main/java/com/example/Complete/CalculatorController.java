package com.example.Complete;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


    @RestController
    public class CalculatorController {

        @RequestMapping(value = "/calculator", method = RequestMethod.GET)
        public String calculatorLanding(){
            return "To use the calculator, please append /calculator URL with your chosen calculation method. The methods supported are /calculator/addition, /calculator/subtraction or /calculator/multiplication";
        }

        @RequestMapping(value = "/addition", method = RequestMethod.GET)
        public String addition(@RequestParam int num1, @RequestParam int num2){
            int result = num1 + num2;
            System.out.println(result);

            return "Added " + num1 + " and " + num2 + " and the answer is: " + result;
        }

        @RequestMapping(value = "/subtraction", method = RequestMethod.GET)
        public String subtraction(@RequestParam int num1, @RequestParam int num2){
            int result = num1 - num2;
            System.out.println(result);

            return "Subtracted " + num1 + " and " + num2 + " and the answer is: " + result;
        }

        @RequestMapping(value = "/multiplication", method = RequestMethod.GET)
        public String multiplication(@RequestParam int num1, @RequestParam int num2){
            int result = num1 * num2;
            System.out.println(result);

            return "Multiplied " + num1 + " and " + num2 + " and the answer is: " + result;
        }

        @RequestMapping(value = "/calculator/{calcMethod}", method = RequestMethod.GET)
        public String calculating(@RequestParam ArrayList<Integer> number, @PathVariable String calcMethod){

            if(!(calcMethod.equals("addition") || calcMethod.equals("subtraction") || calcMethod.equals("multiplication"))){
                return "Please choose a calculation method from the following: addition, subtraction or multiplication";
            }else if(number.size() <=1){
                return "Please enter ATLEAST two numbers to be calculated!";
            }else if(calcMethod.equals("addition")){
                calculatorBean calc = new calculatorBean();
                int result = 0;
                for (Integer integer : number) {
                    result += integer;
                }
                calc.setAnswer(result);
                System.out.println(calc.getAnswer());
                return "Added the numbers in the list " + number + " and the answer is: " + calc.getAnswer();

            }else if(calcMethod.equals("subtraction")) {
                calculatorBean calc = new calculatorBean();
                int result = number.get(0);
                for(int n=0; n< number.size()-1; n++){
                    result -= number.get(n+1);
                }
                calc.setAnswer(result);
                System.out.println(calc.getAnswer());
                return "Subtracted the numbers in the list " + number + " and the answer is: " + calc.getAnswer();
            }else{
                calculatorBean calc = new calculatorBean();
                int result = number.get(0);
                for(int n=0; n< number.size()-1; n++){
                    result *= number.get(n+1);
                }
                calc.setAnswer(result);
                System.out.println(calc.getAnswer());
                return "Multiplied the numbers in the list " + number + " and the answer is: " + calc.getAnswer();
            }
        }
}

