package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.date.Alphabet;

import java.io.PrintStream;

public class decodingByBruteForce {

    private static final int MIM_OF_POPULAR_LETTERS = 5;


    public static void startBruteForce() {

        String text = GetText.startGetText();

        String textResult = algorithmBruteForce(text, System.out);

        WriteText.startWriting(textResult);
    }

    private static String algorithmBruteForce(String text, PrintStream out) {
        for (int i = 0; i < Alphabet.LENGTH_OF_ALPHABET; i++) {

            String testText = Decoding.decodeWithKey(text, i);
            boolean resultTest = checkForExit(testText);

            if (resultTest) {
                out.println("key = " + i);
                return testText;
            }
        }
        return null;
    }

    public static boolean checkForExit(String testText) {

        int index = 0;

        for (int i = 0; i < Alphabet.POPULAR_LETTERS.length; i++) {
            if (testText.contains(Alphabet.POPULAR_LETTERS[i])) {
                index++;
            }
        }
        return index >= MIM_OF_POPULAR_LETTERS;
        }
    }

