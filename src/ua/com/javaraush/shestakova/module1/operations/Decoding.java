package ua.com.javaraush.shestakova.module1.operations;

import java.util.*;

public class Decoding {
    public void startDecoding() {

            int key = GetKey.KEY;
            String text = GetText.getTextFromUser();
            String result = AlgorithmDecodingWithKey(text, key);
            System.out.println(result);
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
//    public static void metric (String result) {
//
//        int textSize = result.length(); // 29 705
//        List<String> list = new ArrayList<>();
//        for (String x : result.split(" ")){
//            list.add(x);
//            System.out.println(x);
//        }
//
//        int letter1 = Collections.frequency(list, "и"); // 188
//        int letter2 = Collections.frequency(list, "в"); // 158
//        int letter3 = Collections.frequency(list, "не"); // 53
//        int letter4 = Collections.frequency(list, "я");
//
//
//        System.out.println(textSize);
//
//        System.out.println("И: " + letter1 + "\nВ: " + letter2 + "\nНЕ: " + letter3 + "\n." + letter4);
//    }
    }
