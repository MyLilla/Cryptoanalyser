package ua.com.javarush.shestakova.module1.date;

public class Alphabet {
    public static final String GET_OF_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "-.,–—\'\":!?*# " +
            "abcdefghijklmnopqrstuvwxyz" +
            "1234567890";
    public static final int LENGTH_OF_ALPHABET = GET_OF_ALPHABET.length();

    public static final char[] ALPHABET_ARRAY = Alphabet.GET_OF_ALPHABET.toCharArray();

    public static final String[] POPULAR_LETTERS = new String[]
            {" и ", " на ", " в ", ". ", "не", "я", "and", "to","of", "the", "a"};
}
