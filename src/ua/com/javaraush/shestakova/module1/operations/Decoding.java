package ua.com.javaraush.shestakova.module1.operations;

public class Decoding {
    public static void startDecoding() {

        int key = GetKey.getTheKey();

        String text = GetText.getTextFromUser();

        String result = AlgorithmDecodingWithKey(text, key);

        WriteText.startWriting(result);
    }

    public static String AlgorithmDecodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.alphabet.indexOf(text.charAt(i)); // получаю индекс буквы в алфавите, которую двигать
            int stepBack = (index - key) % alphabet.alphabetLength; // на сколько двигать
            if (stepBack < 0) {
                char encoding = alphabet.alphabet.charAt(alphabet.alphabetLength - Math.abs(stepBack));
                result.append(encoding);
            } else {
                char encoding = alphabet.alphabet.charAt(stepBack);
                result.append(encoding);
            }
        }
        return result.toString();
    }
}
