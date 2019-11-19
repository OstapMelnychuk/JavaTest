package com.company;

public class Main {

    public static void main(String[] args) {
        Code code = new Code("Helo", 'b');
        code.getCodeNumber();
        code.getOurMassage();
        String msg1 = code.result();
        System.out.println(msg1);


    }
}
