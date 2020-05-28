
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		 Scanner scanner = new Scanner(System.in);
		 
	        Random random  = new Random();
	     
	        System.out.println("Välkommen till spelet hänga gubbe"); // GUBBE -> G,U,B,B,E
	        System.out.println("Enter a username");
	        String userName = scanner.nextLine(); 
	        System.out.println(userName +",Choose male or female (male/female)");
	        String tempSex = scanner.nextLine();
	        String sex = null;

	            if (!tempSex.equals("male") && ! tempSex.equals("female")) {
	                System.out.println( userName + "Only male or female are available (male/female)");
	            } 
	            

	            System.out.println("Okay " + sex +" "+ userName + " Enter clas");
	            String klass = scanner.nextLine(); 
	            System.out.println("Final step, please choose race  (human/drawf/priest/orc)");
	            String tempRace = scanner.nextLine();
	            String race;

	            if (!"human".equals(tempRace) && !"drawf".equals(tempRace) && !"priest".equals(tempRace) && !"orc".equals(tempRace)) {
	                System.out.println( userName + "Only following races"); 
	            }
	            
	            String switchStatement = "'Perfect!' + userName + sex + klass + race";
	            switch(tempRace) {
	                case "human": 
	                System.out.println(switchStatement + "SKRIV DITT INTRO1"); 
	                break; 
	            case "drawf": 
	                System.out.println(switchStatement + "SKRIV DITT INTRO2"); 
	                break; 
	            case "priest": 
	                System.out.println(switchStatement + "SKRIV DITT INTRO3"); 
	                break; 
	            case "orc": 
	                System.out.println(switchStatement + "SKRIV DITT INTRO4"); 
	                break; 
	            default: 
	                System.out.println(switchStatement + "SKRIV DITT INTRO5"); 
	            }


	        boolean weArePlay = true;
	        while (weArePlay) {
	        	
	        
	        		char[] randomWordToGuess = getWordList() .get(random.nextInt(getWordList().size())).toCharArray(); //tar ett ord
	   	            int amountOfGuesses = randomWordToGuess.length; //lägg in antalet gissningar
	   	            char[] playerGuess = new char[amountOfGuesses]; 

	   	            for(int i = 0; i < playerGuess.length; i++) 
	   	            	playerGuess[i] = '_';
	        	    

	            boolean wordIsGuessed = false;
	            int tries = 0;

	            while(!wordIsGuessed && tries != amountOfGuesses) { //medan ordet inte är gissat och antalet försök inte är förbrukade
	                System.out.println("Current guesses: ");
	                printArray(playerGuess);
	                System.out.printf("you have %d tries left. %n", amountOfGuesses - tries);
	                System.out.println("Enter a single characater");
	                char input = scanner.nextLine().charAt(0); //även om input är haudsahuid tas bara h (problematisk vid tom input)
	                tries++;
	                if(input == '-') {
	                    weArePlay = false;
	                    wordIsGuessed = true;
	                } else {
	                    for(int i = 0; i < randomWordToGuess.length; i++) {
	                        if(randomWordToGuess[i] == input) playerGuess[i] = input;
	                    }
	                    if(isTheWordGuessed(playerGuess)) { //vid vinst
	                        wordIsGuessed = true;
	                        System.out.println("Congratulations You won");
	                    }
	                }
	            }
	            if(!wordIsGuessed) System.out.println("You ran out of guesses!"); // slut på gissningar
	            System.out.println("Do you want to play another game of hangman? (yes/no)");
	            String anotherGame = scanner.nextLine();
	            if(anotherGame.equals("no")) weArePlay = false;
	        }

	        System.out.println("Game over");
	}
	

	public static void printArray(char[] array) {
	    for(int i = 0; i < array.length; i++) {
	        System.out.print(array[i]+ " "); //skriver ut arrayen
	    }
	        System.out.println();
	}

	public static boolean isTheWordGuessed(char[] array) { //metod som kollar om input är rätt
	    for(int i = 0; i < array.length; i++) {
	        if (array[i] == '_') return false;
	    }
	    return true;
	}

	public static LinkedList<String> getWordList() throws FileNotFoundException {
	    LinkedList<String> list = new LinkedList<String>();
	    int counter = 0;
	    int maxWords = 1000; 
	    File file = new File("C://Users//Martin Jjooga//eclipse-workspace//Hangman//src//Wordlist.txt");
	    Scanner sc = new Scanner(file); 
	    
	    while (sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            list.add(inputLine);
	        counter++;
	        if (counter == maxWords) break;
        }

	    return list;
	}

	}