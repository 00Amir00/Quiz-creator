package ghasemia;

/**
 *
 * Assignment 3
 *
 * Program : Developing a class that models a multi-option question
 *
 * This class name is Assign3Main, and it contains the main method.
 *
 * @author Amirmahdi Ghasemi, July 2020
 */
/**
 * here you can find the classes which were imported by the programmer.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the default constructor of the class, and it contains the main
 * method.
 */
public class Main {

    //Main method 
    public static void main(String[] args) {
        // This is the ArrayList that will contain questions
        ArrayList<Question> list = new ArrayList<Question>();
        /* TODO 1:
           create an empty array list to hold your quiz qustions
         */
        // Declaring a new scanner for getting information from the user
        Scanner in = new Scanner(System.in);
        // Declaring the variable choice and assigning a value to the variable to hold the user's choice
        int choice = 1;
        // Declaring a do-while loop to keep and get the information we need
        do {
            // These lines will be printed for the user when the program executed
            System.out.print("What would you like to do?\n"
                    + "1. Create A Quiz\n"
                    + "2. Take a Quiz\n\n"
                    + "Option (1 or 2, anything other # quits): ");
            // Here the user will enter his/her choice
            choice = in.nextInt();
            /*
            These conditions will be executed when the user enter his/her choice
             */
            // If the user choice is 1, the createQuiz method will be executed
            if (choice == 1) {
                createQuiz(list);
                // If the user choice is 2, first the program make sure the ArrayList is not empty
            } else if (choice == 2) {
                /*
                If the ArrayList is empty, it will print the following statment,
                and ask the user to make a quiz first
                 */
                if (list.isEmpty()) {
                    System.out.println("No questions! Create a quiz, first!");
                    // Adding a new line
                    System.out.println();
                    // If the ArrayList contains a quiz, the takeQuiz method will be executed
                } else {
                    takeQuiz(list);
                }
                // If the user enter anything except 1 or 2, the program will end the session
            } else if (choice != 1 || choice != 2) {
                System.out.println("Exiting...");
                break;

            }
            /* TODO 2:
            switch or if-stmt, you pick:
            - if user chooses 1, run createQuiz() method
            - if user chooses 2, run takeQuiz() method
            - see assignment specs for detauls on what these methods should do,
              return, accept as args, etc.
            NOTE: if user chooses 2, check to make sure that there are questions
            in the array list: if not, say No questions!  Create a quiz, first!
            otherwise, go ahead and execute takeQuiz() method
             */
            // Here you can see the conditions of the loop
        } while (choice == 1 || choice == 2);
        // The last line that will be printed
        System.out.println("Thanks!  Bye!");
        // Setting the value of the scanner to the null
        in = null;
    }

    /* TODO 3:
       Write the createQuiz() method.
       See assignment specs for detailed instructions.
     */
    // The createQuiz method that will take one parameter which is ArrayList
    public static void createQuiz(ArrayList<Question> list) {
        // Creating a new scanner for gathering information
        Scanner sc = new Scanner(System.in);
        // A char variable that indicate user's request to add another question or not
        char addAnotherQuestion = 'y';
        // Declaring a new variable which will keep track of the question numbers
        int counter = 0;
        // A do-while loop that will get and keep the information
        do {
            // Each time will be incremented by the loop
            counter++;
            // The following statement will be printed by the scanner
            System.out.println("Enter question text: ");
            /*
            The programmer used this condition because after 
            the first round of the loop the question string will be ignored by the scanner, 
            therefore by this condition, the problem will be solved
             */
            if (counter > 1) {
                sc.nextLine();
            }
            // Taking the question text from the user, and declaring it as a String
            String question = sc.nextLine();
            // The following statement will be printed by the scanner
            System.out.print("How many options does your question have? ");
            /*
            int optionsNum = sc.nextInt;
            The problem of the above statement was the scanner would skip this part,
            so the programmer had to use Integer.parseInt
             */
            int optionsNum = Integer.parseInt(sc.nextLine());
            // If the optionsNum is less than 2, it will throw an ecxeption
            if (optionsNum < 2) {
                throw new IllegalArgumentException("Error: there must be at least 2 options.");
            }
            // Declaring a char array that contains alphabet of English language
            char[] arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            // An array to hold the user's options
            String[] arrOptions = new String[optionsNum];
            // A for loop which asks the user enter their options
            for (int i = 0; i < optionsNum; i++) {
                // Printing the following statement with char array already declared
                System.out.print("Enter option " + arr[i] + ": ");
                // Storing the options
                String Options = sc.nextLine();
                // Combining the letters of the char array with options
                arrOptions[i] = arr[i] + ")" + Options;
            }
            // The following statement will be printed by the scanner
            System.out.println("Which option is the correct answer? ");
            // A for-each loop that will print all the options that the user entered 
            for (String s : arrOptions) {
                System.out.println(s);
            }
            // Instantiate a new object from the information that collected from the user
            Question object = new Question(counter, question, arrOptions);
            // Storing the correct that will be entered by the user
            char correctAns = Character.toUpperCase(sc.next().charAt(0));
            // Setting the correct answer
            object.setAnswer(correctAns);
            // Adding the object to the ArrayList
            list.add(object);
            // Asking the user, if they want to add another question or not
            System.out.print("Add another? (Y/N) ");
            addAnotherQuestion = sc.next().charAt(0);
            // Adding a new line
            System.out.println();
            // The condition of the do-while loop
        } while (addAnotherQuestion != 'n');

    }

    /* TODO 4:
       Write the takeQuiz() method.
       See assignment specs for detailed instructions.
     */
    // The createQuiz method that will take one parameter which is ArrayList
    public static void takeQuiz(ArrayList<Question> list) {
        // Creating a new scanner for gathering information
        Scanner sc = new Scanner(System.in);
        // Declaring a new variable which will keep track of the correct questions
        int correctAns = 0;
        // Adding a new line
        System.out.println();
        // This line shows the user which the quiz has been started
        System.out.println("Quiz Time!");
        System.out.println("------------------");
        // Adding a new line
        System.out.println();
        // A for loop that will print the questions for the user
        for (int i = 0; i < list.size(); i++) {
            // This line prints the question number and question text
            System.out.println(list.get(i).getQuestionNum() + ": " + list.get(i).getQuestionText());
            // A for-each loop that will print all the options for the user
            for (String option : list.get(i).getOptions()) {
                System.out.println(option);
            }
            // The following statement will be printed by the scanner
            System.out.print("Answer: ");
            // Storing the answer of the user
            char answer = Character.toUpperCase(sc.next().charAt(0));
            // This condition will check the user's answer
            // If it is right, this condition will increase the correctAns by one
            if (list.get(i).isCorrect(answer)) {
                correctAns++;
            }
            // Adding a new line
            System.out.println();
        }
        // Calculating the grade of the user and casting it to double
        double score = ((double) correctAns / (double) list.size()) * 100;
        // Importing the decimal format package for configuring the decimal places
        DecimalFormat df = new DecimalFormat("###.#");
        // Printing the score of the user
        System.out.println("Your Score: "
                + correctAns + "/" + list.size() + " (" + df.format(score) + "%)" + "\n");

    }

}
