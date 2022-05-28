package ua.com.javaraush.shestakova.module1.Other;

 public class Alphabet {
  public static final  String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                                          "-.,–\'\":!?*# " +
                                          "abcdefghijklmnopqastuvwxyz" +
                                           "1234567890";
  public static final int alphabetLength = alphabet.length();

  public static final  char [] alphabetArray = Alphabet.alphabet.toCharArray();

 }
