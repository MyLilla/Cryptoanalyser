package ua.com.javarush.shestakova.module1.Algorithms;

import ua.com.javarush.shestakova.module1.Date.Alphabet;
import ua.com.javarush.shestakova.module1.Date.Color;
import ua.com.javarush.shestakova.module1.ResourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.ResourcesFromUser.WriteText;

import java.io.PrintStream;
import java.util.*;

public class StatisticalAnalysis {

    public static void startAnalysis() {

            String text = GetText.getTextFromUser();
            String result = algorithmStatistical(text, System.out);
        WriteText.startWriting(result);
    }
    public static String algorithmStatistical(String textFromUser, PrintStream out) {

        char symbolInCode = GetMaxTimesSymbol(textFromUser);

        int indexSymbolInAlpha = getIndexFromAlphabet(Alphabet.alphabetArray, symbolInCode);
        int indexSpase = getIndexFromAlphabet(Alphabet.alphabetArray, ' ');

        if (indexSymbolInAlpha == indexSpase){
           out.println("Это " + Color.RED + "не зашифрованный текст" + Color.RESET +
                   ".Скорей всего, шифровка была не через эту программу. " +
                    "проверьте текст (и свои навыки чтения) и возвращайтесь");
            System.exit(1);
        }
        int keyMinus = indexSpase - indexSymbolInAlpha;
        int keyPlus = indexSymbolInAlpha - indexSpase;

        String result = null;
        if (BruteForce.checkForExit(Decoding.DecodeWithKey(textFromUser, keyPlus))) {
            result = Decoding.DecodeWithKey(textFromUser, keyPlus);
            out.println("Ключь к коду = " + keyPlus);
        } else if (BruteForce.checkForExit(Decoding.DecodeWithKey(textFromUser, keyMinus))) {
            result = Decoding.DecodeWithKey(textFromUser, keyMinus);
            out.println("Ключь к коду = " + keyMinus);
        }
        return result;
    }

    private static int getIndexFromAlphabet(char[] array, char symbol) {
        int index = 0;
        for (int i = 0; i < Alphabet.alphabet.length(); i++) {
            if (Alphabet.alphabetArray[i] == symbol) {
                index = i;
                continue;
            }
        }
        return index;
    }
    private static Character GetMaxTimesSymbol(String textFromUser) {

        String[] arrayTextFromUser = textFromUser.split("");

        Map<Object, Integer> map = new HashMap<>();

        for (int i =0; i < arrayTextFromUser.length; i++) {
            char temp = arrayTextFromUser[i].charAt(0);

            if (map.containsKey(temp))
            {
                map.put(temp, Integer.parseInt(map.get(temp).toString()) + 1);
            } else {
                map.put(temp, 0);
            }
        }
        Integer max = Collections.max (map.values());
        Character result = null;

        for (Map.Entry entry : map.entrySet())
        {
            if (max == entry.getValue()){
                result = (char) entry.getKey();
            }
        }
        return result;

    }
}
