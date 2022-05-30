package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.date.Alphabet;

public class BruteForce {


    public static void startBruteForce() {

        String text = GetText.getTextFromUser();

        String textResult = algorithmBruteForce(text);

        WriteText.startWriting(textResult);
    }

    private static String algorithmBruteForce(String text) {
        for (int i = 0; i < Alphabet.alphabetLength; i++) {

            String testText = Decoding.DecodeWithKey(text, i);
            boolean resultTest = checkForExit(testText);

            if (resultTest) {
                System.out.println("key = " + i);
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
        if (index >= 5) {
            return true;
        } else {
            return false;
        }
    }
}
