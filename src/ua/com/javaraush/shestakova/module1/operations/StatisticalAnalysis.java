package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StatisticalAnalysis {

    public static void startAnalysis() {
        try {
            String text = GetText.getTextFromUser(); // есть зашифрованный текст от пользователя
            metric(text);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public static void metric(String textWithShifr) throws IOException { // передается зашифрованый


        String textNew = textWithShifr;


        }


    public static void withOriginal () throws IOException{ // c оргиналом

        List<String> list = new ArrayList<>(getTEXTforMert()); // текст расшифрованый из листа в

        int textSize = list.size();           // 29 705
        String orig = list.toString(); // расшифрованный в листе

        for (String x : orig.split(" ")) {  // проход по разбитому на слова листу
            list.add(x);
            System.out.println(x);
        }

        int letter1 = Collections.frequency(list, "и"); // 188
        int letter2 = Collections.frequency(list, "в"); // 158
        int letter3 = Collections.frequency(list, "не"); // 53
        int letter4 = Collections.frequency(list, " "); // 53
        System.out.println(letter4);


        int IpercentageOfText = (letter1 / textSize) * 100;
        int VpercentageOfText = (letter2 / textSize) * 100;
        int NEpercentageOfText = (letter3 / textSize) * 100;
        int SpaceInText = (letter3 / textSize) * 100;
        System.out.println(SpaceInText);

    }


    public static List<String> getTEXTforMert () throws IOException {

        String test = "D://Cryptoanalyser/test.txt";
        List<String> list1 = Files.readAllLines(Path.of(test));

//        StringBuilder builder1 = new StringBuilder();
//        for (String x : list1) {
//            builder1.append(x);
//        }
//        String text = builder1.toString().toLowerCase(); // текст для метрик String



        return list1;
    }


}
