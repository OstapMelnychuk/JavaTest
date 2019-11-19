package com.company;

import java.util.Scanner;

public class Code {

    public Scanner scan = new Scanner(System.in);
    public Scanner scann = new Scanner(System.in);
    public char codeNumber;
    public String massage;



    public void getCodeNumber(){
        System.out.println("Введіть кодову букву");
        codeNumber = scan.next().charAt(0);
    }
    public void getOurMassage(){
        System.out.println("Введіть повідомлення для кодування: ");
        massage = scann.nextLine().toString();

    }
    public char codding(char c, int quolity){
        int a = (int) c+ (int) codeNumber;
        if(a>=quolity+26){
            int b = (a/26);
            a =(((a)-26*b)+quolity);

        }
        return (char) a;
    }
    public String result(){
        String str = "";
        for (int i = 0; i<massage.length(); i++){
            char c = massage.charAt(i);
            if((c>=65) && (c<=90)) {
                str += codding(c, 65);
            }
            else {
                if ((c>=97) && (c<=122)) {
                    str += codding(c, 97);
                }
                    else {
                    str += c;
                }
                }
            }
        return str;
        }


    public Code(String massage, char codeNumber) {
        this.massage = massage;

        this.codeNumber = codeNumber;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setCodeNumber(char codeNumber) {
        this.codeNumber = codeNumber;
    }
}
