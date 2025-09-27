
import java.util.*;

// Number Game! .

public class Task1{
    public static void main(String args[]){

       Scanner sc = new Scanner(System.in); 
       Random ra = new Random();

       final int max_attempts = 7 ; 
       final int lower_bounds = 1 ;
       final int upper_bounds = 100 ;

       int totalScore = 0 ;
       int roundsPlayed = 0 ;

       System.out.println("welcome to number guessing game!");
       boolean playAgain ;

       do { 
           
           int targetNumber = ra.nextInt(upper_bounds - lower_bounds +1) + lower_bounds ;
           int attemptsLeft = max_attempts ;
           boolean guess_write = false ;

           System.out.println("i think number between " +lower_bounds + " " +upper_bounds+ " ");
           System.out.println("you have " + max_attempts + " attempts to guess it.");

           while(attemptsLeft > 0){

            System.out.println("Enter your guess");
            int userGuess ;

            if(sc.hasNextInt()){
                userGuess = sc.nextInt();
            } else {
                System.out.println("invalid number. Please try again");
                sc.next();
                continue ;
            }

            if(userGuess < lower_bounds || userGuess > upper_bounds){

                System.out.println("Please guess a number between " +lower_bounds + " " + upper_bounds + " ");
                continue; 
            }
               attemptsLeft-- ;

            if(userGuess == targetNumber){
                guess_write = true ;

                int scoreFound  = attemptsLeft + 1 ;
                totalScore += scoreFound ;
                System.out.println("correct! you've guesses the number in " +(max_attempts - attemptsLeft)+ "attempt(s).");
                System.out.println("you guess score " + scoreFound );
                break ;

            }   else if(userGuess < targetNumber) {

                System.out.println("too low! attempts left:" + attemptsLeft);

            } else {

                System.out.println("too high! attempts left:" +attemptsLeft);
            }

           }

           if(!guess_write){

            System.out.println("You've run out of attempts! The number was " +targetNumber);

           }

           roundsPlayed++ ;

           // Ask to play again

           System.out.print("Do you want to play another round ?");
           sc.nextLine();
           String response = sc.nextLine().trim().toLowerCase();
           playAgain = response.equals( "yes") || response.equals( "Y");

       } while (playAgain);

       System.out.println("Game over!");
       System.out.println("rounds played:" +roundsPlayed);
       System.out.println("total score:" +totalScore);

       sc.close();
    }
}