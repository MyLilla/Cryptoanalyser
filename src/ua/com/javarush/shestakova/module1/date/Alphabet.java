package ua.com.javarush.shestakova.module1.date;

 public class Alphabet {
  public static final  String GET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                                          "-.,–\'\":!?*# " +
                                          "abcdefghijklmnopqastuvwxyz" +
                                           "1234567890";
  public static final int LENGTH = GET.length();

  public static final  char [] LIKE_ARRAY = Alphabet.GET.toCharArray();
  public static final String[] POPULAR_LETTERS = new String[]{" и ", " на ", " в ", ". ", "не", "я"};

 }

