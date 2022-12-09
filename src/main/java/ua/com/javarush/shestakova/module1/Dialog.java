package ua.com.javarush.shestakova.module1;

import ua.com.javarush.shestakova.module1.algorithms.DecodingByBruteForce;
import ua.com.javarush.shestakova.module1.algorithms.Coding;
import ua.com.javarush.shestakova.module1.algorithms.Decoding;
import ua.com.javarush.shestakova.module1.algorithms.DecodingByStatisticalAnalysis;
import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;

import java.io.PrintStream;
import java.util.Scanner;

public class Dialog {

    private final String INPUT_KEY_FROM_USER = "Enter key number: ";
    private final String SAVED_FILE = "The file is saved in the specified folder";
    public void welcome(PrintStream out) {
        try {
            out.println(Color.GREEN + "What do you want to do? \n" + Color.RESET);
            out.println("Encrypt text enter - 1");
            Thread.sleep(100);
            out.println("Decrypt text using key enter - 2");
            Thread.sleep(100);
            out.println("Decrypt text using \"Brute Force\" enter - 3");
            Thread.sleep(100);
            out.println("Decrypt text using \"Statistical analysis\" enter - 4");
            Thread.sleep(100);
            out.println("for exit enter - 0");
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception with sleep." + e);
        }
        int numberFromUser = getNumberFromUser(out);
        choiceOfOperation(numberFromUser, System.out);
    }

    public int getNumberFromUser(PrintStream out){
        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfOperation = Integer.parseInt(scanner.nextLine());
            if (numberOfOperation > 4 || numberOfOperation < 0) {
                out.println("The number must be " + Color.RED + "from 0 to 4" + Color.RESET);
                throw new InvalidUserInputException ("Incorrect number");
            }
            return numberOfOperation;
        } catch (NumberFormatException e) {
            out.println("It is not " + Color.RED + "number" + Color.RESET);
            throw new InvalidUserInputException("Not number" + e.getMessage() + e);
        }
    }
    private void choiceOfOperation(int numberOfOperation, PrintStream out) {
            switch (numberOfOperation) {
                case 1:
                    out.println(INPUT_KEY_FROM_USER);
                    new Coding().startCoding();
                    out.println(SAVED_FILE);
                    break;
                case 2:
                    out.println(INPUT_KEY_FROM_USER);
                    new Decoding().startDecoding();
                    out.println(SAVED_FILE);
                    break;
                case 3:
                    new DecodingByBruteForce().startBruteForce();
                    out.println(SAVED_FILE);
                    break;
                case 4:
                    new DecodingByStatisticalAnalysis().startAnalysis();
                    out.println(SAVED_FILE);
                    break;
                case 0:
                    out.println(Color.CYAN + "Ok");
                    break;
            }
    }
}
