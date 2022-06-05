package ua.com.javarush.shestakova.module1.algorithms;

import ua.com.javarush.shestakova.module1.resourcesFromUser.KeyService;
import ua.com.javarush.shestakova.module1.resourcesFromUser.GetText;
import ua.com.javarush.shestakova.module1.resourcesFromUser.WriteText;
import ua.com.javarush.shestakova.module1.date.Alphabet;

public class Decoding {
    public static void startDecoding() {

        int key = KeyService.getKey(System.out);

        String text = GetText.getPathFromUser();

        String result = DecodeWithKey(text, key);

        WriteText.startWriting(result);
    }

    public static String DecodeWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = Alphabet.GET.indexOf(text.charAt(i));
            int stepBack = (index - key) % Alphabet.LENGTH;
            if (stepBack < 0) {
                char encoding = Alphabet.GET.charAt(Alphabet.LENGTH - Math.abs(stepBack));
                result.append(encoding);
            } else {
                char encoding = Alphabet.GET.charAt(stepBack);
                result.append(encoding);
            }
        }
        return result.toString();
    }
}
