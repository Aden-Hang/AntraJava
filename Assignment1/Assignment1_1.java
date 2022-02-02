package Assignment1;

import java.util.Scanner;

public class Assignment1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
        for(;;){
            System.out.print("Please enter a integer larger than 0 or q for quit: ");
            input = sc.next();

            if(input.equals("q") || input.equals("Q")){
                break;
            }

            if(Integer.parseInt(input) <= 0) {
                System.out.println("Please enter a positive integer");
            }else {
                doSomething(Integer.parseInt(input));
            }
        }
    }

    public static void doSomething(int input){
        System.out.print("The sum of 1 to " + input);
        int sum = 0;
        for(int i=1;i<=input;i++){
            sum += i;
        }
        System.out.println(" is " + sum);
    }
}
