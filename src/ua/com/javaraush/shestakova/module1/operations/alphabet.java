package ua.com.javaraush.shestakova.module1.operations;

 class alphabet {

  static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з',
          'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
          'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '-', '»', '"', '\'', ':', '!', '?', ' '};
  static final int alphabetLength = ALPHABET.length;

  public char[] getALPHABET() {
   return ALPHABET;
  }

  public int getAlphabetLength() {
   return alphabetLength;
  }
 }

