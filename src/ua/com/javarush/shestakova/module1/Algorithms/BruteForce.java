package ua.com.javarush.shestakova.module1.Algorithms;

import ua.com.javarush.shestakova.module1.ResourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.ResourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.Date.Alphabet;

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
