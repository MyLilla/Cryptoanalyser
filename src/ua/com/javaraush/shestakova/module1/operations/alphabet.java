package ua.com.javaraush.shestakova.module1.operations;

 class alphabet {

  public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з',
          'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
          'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '-', '"', '\'', ':', '!', '?', ' '};

  public static final  String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,-'\":!? ";

  public static final int alphabetLength = ALPHABET.length; // 41 c 1

  public String getAlphabet (){
   return alphabet;
  }
  public char[] getALPHABET() {
   return ALPHABET;
  }

  public int getAlphabetLength() {
   return alphabetLength;
  }

 }

