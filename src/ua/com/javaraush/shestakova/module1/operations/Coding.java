package ua.com.javaraush.shestakova.module1.operations;

public class Coding {
    public void startCoding() {

        int key = GetKey.KEY;
        String text = GetText.getTextFromUser();
        String result = AlgorithmCodingWithKey(text, key);
        System.out.println(result);

        WriteText.addPath();
    }
    public String AlgorithmCodingWithKey(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.alphabet.indexOf(text.charAt(i)); // получаю индекс буквы в алфавите, которую двигать
            int steps = (index + key) % alphabet.alphabetLength; // на сколько двигать

            if (index < Math.abs(key) && (key < 0)) {
                result.append(alphabet.alphabet.charAt(alphabet.alphabetLength - Math.abs(steps)));
            } else {
                result.append(alphabet.alphabet.charAt(steps));
            }
        }

        return result.toString();
    }

}
