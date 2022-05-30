package ua.com.javarush.shestakova.module1.date;

 public class Alphabet {
  public static final  String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                                          "-.,–\'\":!?*# " +
                                          "abcdefghijklmnopqastuvwxyz" +
                                           "1234567890";
  public static final int alphabetLength = alphabet.length();

  public static final  char [] alphabetArray = Alphabet.alphabet.toCharArray();
  public static final String[] POPULAR_LETTERS = new String[]{" и ", " на ", " в ", ". ", "не", "я"};

 }

