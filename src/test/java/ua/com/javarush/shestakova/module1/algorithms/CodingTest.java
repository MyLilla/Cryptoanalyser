package ua.com.javarush.shestakova.module1.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ua.com.javarush.shestakova.module1.algorithms.Coding.algorithmCodingWithKey;

class CodingTest {

    @Test
    void startCoding() {
    }

    /*
    - правильный текст
    - текст null

     */
    @Test
    void algorithmCodingWithKey_WhenTextIsOK_ResultNotNull() {
        assertNotNull(algorithmCodingWithKey("Text", 1));
    }
    @Test
    void algorithmCodingWithKey_WhenBothOk() {
        String expected = "whvw";
        String actual = algorithmCodingWithKey("test", 3);

        assertEquals(expected, actual);
    }

    @Test
    void algorithmCodingWithKey_WhenTextNull() {

    }
}