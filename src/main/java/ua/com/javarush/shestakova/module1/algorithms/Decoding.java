package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.resourcesFromUser.KeyService;
import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.date.Alphabet;

public class Decoding {
    public void startDecoding() {

        int key = KeyService.getKey(System.out);

        String text = GetText.startGetText();

        String result = decodeWithKey(text, key);

        WriteText.startWriting(result);
    }

    public static String decodeWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.GET_OF_ALPHABET.indexOf(text.charAt(i));
            int stepBack = (index - key) % Alphabet.LENGTH_OF_ALPHABET;
            if (stepBack < 0) {
                char encoding = Alphabet.GET_OF_ALPHABET.charAt(Alphabet.LENGTH_OF_ALPHABET - Math.abs(stepBack));
                result.append(encoding);
            } else {
                char encoding = Alphabet.GET_OF_ALPHABET.charAt(stepBack);
                result.append(encoding);
            }
        }
        return result.toString();
    }
}
