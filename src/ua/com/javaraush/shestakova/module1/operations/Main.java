package ua.com.javaraush.shestakova.module1.operations;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        encryption test = new encryption();

        try {
            test.operations();
        } catch (IOException e) {
            System.out.println("EXCEPTION " + e);
        }
    }

}


