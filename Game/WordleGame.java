import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class WordleGame {
    //declaring ANSI escape codes to change the collor
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[42m";
    public static final String YELLOW = "\u001B[43m";

    public static void main(String[] args) {

        System.out.println("WELCOME TO WORDLE!");
        //creating a list of words in a array
        String[] words = {"HELLO", "WORLD", "THING", "FIRST", "HOUSE", "POWER", "HORSE", "SPOON", "GUESS", "TABLE", 
        "DREAM", "GUARD", "FLOOD", "ADULT", "SIGHT", "ALARM", "FORCE", "WOUND", "BRAVE", "CABLE",
        "PANIC", "STUDY", "FAITH", "EQUAL", "GRADE", "AWARD", "BULLY", "VOICE", "DRIVE", "TITLE",
        "CHEER", "PAUSE", "LEGAL", "PLATE", "ERROR", "SMASH", "TRADE", "BURST", "FLASH", "SHAME",
        "FLOAT", "STING", "BOOST", "ALIEN", "BLEND", "PARTY", "STORE", "SHINE", "MATCH", "TRACK",
        "ROUTE", "CRASH", "CLOWN", "SHAKY", "VEGAN", "TRUST", "ENJOY", "BRAIN", "ADOPT", "TOWER",
        "SHADE", "DELAY", "TWIST", "ALERT", "CHOKE", "SPLIT", "RHYME", "MUDDY", "PLANT", "FALSE"};

        //selecting an answer randomly
        String answer = words[new Random().nextInt(20)].toUpperCase();
        

        //declaring the condition variables
        int attempts = 0;
        boolean win = false;
        boolean wordList = false;
        String guess;

        //loop for total atempts
       for (attempts=0; attempts<6; attempts++){

        do{   

            //recieving the input from user
            Scanner input = new Scanner(System.in);
            guess = input.nextLine().toUpperCase();

            for(int i=0; i<70; i++){
                if(guess.equals(words[i])){
                wordList = true;
                break;
                }
                else {
                wordList = false;
                }
            }

            if(wordList == false){  //testing if the guess is in the word list
                System.out.println("Not in word list.");
            }
            
        } while (wordList == false);
        
        StringBuffer display = new StringBuffer();   //building a string with collors

        for(int i=0; i<guess.length(); i++){

            char c = guess.charAt(i);
            if (answer.charAt(i) == c) {
                display.append(GREEN + c + RESET);
            } else if(answer.contains(Character.toString(c))){
                display.append(YELLOW + c + RESET);
            } else {
                display.append(c);
            }
        }

        System.out.println(display.toString());  //printing the new string with colors on screen
        
        if (guess.toUpperCase().equals(answer)){  //comparing guess to answer to end the loop
            win = true;
            attempts++;
            break;
        }
        

    }
    
     System.out.println("Attempts: " + attempts);
     
     if (win){
        System.out.println("Congratulations");
     }
     else{
        System.out.println("You lose. The correct word is "+ answer);
     }


    }
}
