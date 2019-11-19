package com.roman_gabchak;

public class Main {
    public static void main(String[] args) {

        String text = "Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java Java";
        String key = "Logos375";

        //Виводить на екран не закодований текст.
        System.out.println("Текст до шифрування:\n" + text);

        //Викликається метод encrypt з классу Encryption та передаютьмя в параметри методу текст, який потрібно зашифрувати та ключ для шифрування.
        //Далі зашифрований текст передається у змінну типу String з назвою encryptedText.
        String encryptedText = Encryption.encrypt(text, key);

        //Виводить на екран закодований текст.
        System.out.println("Защифрований текст:\n" + encryptedText);

        //Викликається метод decrypt з классу Encryption та передаютьмя в параметри методу текст, який потрібно розшифрувати та ключ для розшифрування.
        System.out.println("Розшифрований текст:\n"+Encryption.decrypt(encryptedText, key));


    }
}