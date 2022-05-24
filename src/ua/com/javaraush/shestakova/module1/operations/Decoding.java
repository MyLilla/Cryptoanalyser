package ua.com.javaraush.shestakova.module1.operations;

public class Decoding {
    public void startDecoding() {

            int key = GetKey.KEY;
            String text = GetText.getTextFromUser();

            System.out.println(AlgorithmDecodingWithKey(text, key));
    }
    public static String AlgorithmDecodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) { // по тексту
            int index = alphabet.alphabet.indexOf(text.charAt(i)); // индекс той же буквы в алфавите
            int stepBack = (Math.abs((index - key) % 41));
            if (index >= (alphabet.alphabet.length() + key)) {
                result.append(alphabet.alphabet.charAt(stepBack - 1));
            } else {
                char encoding = alphabet.alphabet.charAt(stepBack);
                result.append(encoding);
            }
        }
        return result.toString();
    }
    }
