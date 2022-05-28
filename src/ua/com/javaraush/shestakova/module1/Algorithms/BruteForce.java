package ua.com.javaraush.shestakova.module1.Algorithms;

import ua.com.javaraush.shestakova.module1.ResursesFromUser.GetText;
import ua.com.javaraush.shestakova.module1.ResursesFromUser.WriteText;
import ua.com.javaraush.shestakova.module1.Other.Alphabet;

public class BruteForce {

    public static void startBruteForce() {

        String text = GetText.getTextFromUser();

        String textResult = AlgorithmBruteForce(text);

        WriteText.startWriting(textResult);
    }
    private static String AlgorithmBruteForce(String text) {
        for (int i = 0; i < Alphabet.alphabetLength; i++) {

            String testText = Decoding.AlgorithmDecodingWithKey(text, i);
            boolean resultTest = checkForExit(testText);

            if (resultTest) {
                System.out.println("key = " + i);
                return testText;
            }
        }
        return null;
    }
    private static boolean checkForExit(String testText) {

        String[] popular = new String[]{" и ", " на ", " в ", ". ", "не", "я"};
        int index = 0;

        for (int i = 0; i < popular.length; i++) {
            if (testText.contains(popular[i])) {
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
