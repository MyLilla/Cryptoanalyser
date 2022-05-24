package ua.com.javaraush.shestakova.module1.operations;

public class Coding {
    public void startCoding() {

        int key = GetKey.KEY;
        String textArray = GetText.getTextFromUser();
        System.out.println(AlgorithmCodingWithKey(textArray, key));
    }
    public String AlgorithmCodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.alphabet.indexOf(text.charAt(i)); // если это 41?
            int stepForward = (Math.abs((index + key) % 41));
            if (index > (alphabet.alphabet.length() - key)) {
                result.append(alphabet.alphabet.charAt(stepForward - 1));
            } else {
                char newSymbol = alphabet.alphabet.charAt(stepForward);
                result.append(newSymbol);
            }
        }
        return result.toString();
    }
}
