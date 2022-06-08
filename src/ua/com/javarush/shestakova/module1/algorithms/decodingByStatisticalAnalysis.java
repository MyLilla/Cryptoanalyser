package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.date.Alphabet;
import ua.com.javarush.shestakova.module1.date.Color;
import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;
import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;

import java.io.PrintStream;
import java.util.*;

public class decodingByStatisticalAnalysis {

    public static void startAnalysis() {

        String text = GetText.startGetText();
        String result = algorithmStatistical(text, System.out);
        WriteText.startWriting(result);
    }

    public static String algorithmStatistical(String textFromUser, PrintStream out) {

        char symbolInCode = GetMaxTimesSymbol(textFromUser);

        int indexSymbolInAlpha = getIndexFromAlphabet(Alphabet.ALPHABET_ARRAY, symbolInCode);
        int indexSpase = getIndexFromAlphabet(Alphabet.ALPHABET_ARRAY, ' ');

        if (indexSymbolInAlpha == indexSpase) {
            out.println("Это " + Color.RED + "не зашифрованный текст" + Color.RESET);
            throw new InvalidUserInputException("The text is original");
        }
        int keyMinus = indexSpase - indexSymbolInAlpha;
        int keyPlus = indexSymbolInAlpha - indexSpase;

        String result = null;
        if (decodingByBruteForce.checkForExit(Decoding.decodeWithKey(textFromUser, keyPlus))) {
            result = Decoding.decodeWithKey(textFromUser, keyPlus);
            out.println("Ключь к коду = " + keyPlus);
        } else if (decodingByBruteForce.checkForExit(Decoding.decodeWithKey(textFromUser, keyMinus))) {
            result = Decoding.decodeWithKey(textFromUser, keyMinus);
            out.println("Ключь к коду = " + keyMinus);
        }
        return result;
    }

    private static int getIndexFromAlphabet(char[] array, char symbol) {
        int index = 0;
        for (int i = 0; i < Alphabet.GET_OF_ALPHABET.length(); i++) {
            if (Alphabet.ALPHABET_ARRAY[i] == symbol) {
                index = i;
                continue;
            }
        }
        return index;
    }

    private static Character GetMaxTimesSymbol(String textFromUser) {

        String[] arrayTextFromUser = textFromUser.split("");

        Map<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < arrayTextFromUser.length; i++) {
            char temp = arrayTextFromUser[i].charAt(0);

            if (map.containsKey(temp)) {
                map.put(temp, Integer.parseInt(map.get(temp).toString()) + 1);
            } else {
                map.put(temp, 0);
            }
        }
        Integer max = Collections.max(map.values());
        Character result = null;

        for (Map.Entry entry : map.entrySet()) {
            if (max == entry.getValue()) {
                result = (char) entry.getKey();
            }
        }
        return result;

    }
}
