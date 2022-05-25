package ua.com.javaraush.shestakova.module1.operations;

public class BruteForce {

    public void startBruteForce() {

        String text = GetText.getTextFromUser(); // есть текст

        for (int i = 0; i < alphabet.alphabetLength; i++) {           // проверка каждого ключа

            String testText = Decoding.AlgorithmDecodingWithKey(text, i); // текст 1
            boolean resultTest = checkForExit(testText); // проверка соответствий

            if (resultTest) {
                System.out.println("key = " + i);
                WriteText.startWriting(testText);
                break;
            }
        }
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