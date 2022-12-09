package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.exceptions.InvalidUserInputException;
import ua.com.javarush.shestakova.module1.resourcesFromUser.KeyService;
import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.date.Alphabet;

import java.io.PrintStream;

public class Coding {
    private final int MAX_KEY = Math.abs(100);

    public void startCoding() {

        int key = KeyService.getKey(System.out);
        checkKeyForCoding(key, System.out);

        String text = GetText.startGetText();
        String result = algorithmCodingWithKey(text, key);

        WriteText.startWriting(result);
    }

    private void checkKeyForCoding(int key, PrintStream out) {
        boolean resultCheck = true;
        while (resultCheck) {
            if (Math.abs(key) > MAX_KEY) {
                out.println("Надежность кодировки не зависит от размера числа, так что можно поменьше: ");
                throw new InvalidUserInputException("Big value of key");
            }
            resultCheck = false;
        }
    }

    public static String algorithmCodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.GET_OF_ALPHABET.indexOf(text.charAt(i));
            int steps = (index + key) % Alphabet.LENGTH_OF_ALPHABET;

            if (index < Math.abs(key) && (key < 0)) {
                result.append(Alphabet.GET_OF_ALPHABET.charAt(Alphabet.LENGTH_OF_ALPHABET - Math.abs(steps)));
            } else {
                result.append(Alphabet.GET_OF_ALPHABET.charAt(steps));
            }
        }
        return result.toString();
    }
}
