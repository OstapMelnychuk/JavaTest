package home;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        Scanner scn = new Scanner(System.in);
        int ask;
        String in;
        System.out.println("Шифратор & дешифратор.");
        System.out.println("1.Шифрувати повідомлення.\n2.Дешифрувати повідомлення.");
        ask = scn.nextInt();
        switch (ask){
            case 1:
                System.out.println("Введіть текст.");
                in = scn.next();
                Coding coding = new Coding(in);
                coding.code();
                coding.two();
                break;
            case 2:
                System.out.println("Введіть шифр.");
                in = scn.next();
                Coding cod = new Coding(in);
                cod.ten();
                cod.decode();
        }
*/
        Coding coding = new Coding("Java");
        coding.code();
        coding.binar();
        coding.decimal();
        coding.decode();
    }
}
