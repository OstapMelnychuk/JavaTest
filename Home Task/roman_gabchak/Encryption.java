package com.roman_gabchak;

import java.util.ArrayList;
import java.util.List;

public class Encryption {

    /***
     * Числовий діапазон малих англійських літер з таблиці "Ascii Table".
     */
    private static final int[] ALPHABET_LOWER_CASE_START_END = {97, 122};

    /***
     * Числовий діапазон Великих англійських літер з таблиці "Ascii Table".
     */
    private static final int[] ALPHABET_UPPER_CASE_START_END = {65, 90};


    /***
     * Метод, який зашифровуе текст за заданим ключом.
     * @param text - вхідний текст, для шифрування.
     * @param key - ключ за яким відбувається шифрування.
     * @return - повертає зашифрований текст.
     */
    static String encrypt(String text, String key) {
        if (!checkingInputText(text) || !checkingInputKey(key)){
            System.exit(0);
        }
        char[] textChars = text.toCharArray();
        int[] keysLocal = keys(key);
        int counter = 0;
        for (int i = 0; i < textChars.length; i++) {
            rollRight(textChars, i, keysLocal[counter++]);
            if (counter == key.length()) {
                counter = 0;
            }
        }
        return String.valueOf(textChars);
    }

    /***
     * Метод, який розшифробує текст за заданим ключом.
     * @param text - вхідний текст, для шифрування.
     * @param key - ключ за яким відбувається шифрування.
     * @return - повертає розшифрований текст.
     */
    static String decrypt(String text, String key) {
        if (!checkingInputText(text) || !checkingInputKey(key)){
            System.exit(0);
        }
        char[] textChars = text.toCharArray();
        int[] keysLocal = keys(key);
        int counter = 0;
        for (int i = 0; i < textChars.length; i++) {
            rollLeft(textChars, i, keysLocal[counter++]);
            if (counter == key.length()) {
                counter = 0;
            }
        }

        return String.valueOf(textChars);
    }

    /***
     * Метод приймає массив символів, та зміщує номер конкретного символа на число 'n' в праву сторону;
     * @param arr - приймає массив чарів.
     * @param index - індекс конкретно символа, який треба змістити.
     * @param n - чило вказуе на скільки одиниць треба змістити пеаниц символ.
     */
    private static void rollRight(char[] arr, int index, int n) {
        int upperStart = ALPHABET_UPPER_CASE_START_END[0];
        int upperEnd = ALPHABET_UPPER_CASE_START_END[1];
        int lowerStart = ALPHABET_LOWER_CASE_START_END[0];
        int lowerEnd = ALPHABET_LOWER_CASE_START_END[1];
        if (arr[index] >= lowerStart && arr[index] <= lowerEnd) {
            if ((arr[index] + n) > lowerEnd) {
                arr[index] = (char) (lowerStart + ((arr[index] + (n)) % lowerEnd));
            } else {
                arr[index] = (char) (arr[index] + n);
            }
        } else if (arr[index] >= upperStart && arr[index] <= upperEnd) {
            if ((arr[index] + n) > upperEnd) {
                arr[index] = (char) (upperStart + ((arr[index] + (n)) % upperEnd));
            } else {
                arr[index] = (char) (arr[index] + n);
            }
        }
    }

    /***
     * Метод приймає массив символів, та зміщує номер конкретного символа на число 'n' в ліву сторону;
     * @param arr - приймає массив чарів.
     * @param index - індекс конкретно символа, який треба змістити.
     * @param n - чило вказуе на скільки одиниць треба змістити пеаниц символ.
     */
    private static void rollLeft(char[] arr, int index, int n) {
        int upperStart = ALPHABET_UPPER_CASE_START_END[0];
        int upperEnd = ALPHABET_UPPER_CASE_START_END[1];
        int lowerStart = ALPHABET_LOWER_CASE_START_END[0];
        int lowerEnd = ALPHABET_LOWER_CASE_START_END[1];
        if (arr[index] >= lowerStart && arr[index] <= lowerEnd) {
            if ((arr[index] - n) < lowerStart) {
                arr[index] = (char) (lowerEnd - (lowerStart % (arr[index] - n)));
            } else {
                arr[index] = (char) (arr[index] - n);
            }
        } else if (arr[index] >= upperStart && arr[index] <= upperEnd) {
            if ((arr[index] - n) < upperStart) {
                arr[index] = (char) (upperEnd - (upperStart % (arr[index] - n)));
            } else {
                arr[index] = (char) (arr[index] - n);
            }
        }
    }


    /***
     * Метод робить перевірку вхідного тексту за певними параметрами.
     * @param text - приймає текст для перевірки.
     * @return - якщо текст відповідає заданим параметрам повертає 'true' в іншому випадку 'false'.
     */
    private static boolean checkingInputText(String text) {
        if (text == null) {
            return false;
        }
        String textPatter = "[ A-Za-z]*";
        if (!text.matches(textPatter)) {
            System.out.println("TEXT: Wrong input text. Only English alphabet from A to z.");
            return false;
        }
        return true;
    }

    /***
     * Метод робить перевірку вхідного тексту за певними параметрами.
     * @param key - приймає текст для перевірки.
     * @return - якщо текст відповідає заданим параметрам повертає 'true' в іншому випадку 'false'.
     */
    private static boolean checkingInputKey(String key) {
        if (key == null) {
            return false;
        }
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,16}$";
        int keyLength = key.length();
        if ((keyLength < 4) || keyLength > 16) {
            System.out.println("KEY: The key length can not be less than 6 characters and not more than 16.");
            return false;
        }
        if (!key.matches(pattern)) {
            System.out.println("KEY: The key must contain at least one lower case letter," +
                    " one upper case letter and digit.");
            return false;
        }
        return true;
    }

    /***
     * Метод приймає строку та перетворює її у масив чисел.
     * @param key приймає текстовий ключ.
     * @return - попертає массив чисел.
     */
    private static int[] keys(String key) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            int temp = key.charAt(i);
            while (temp != 0) {
                if (temp % 10 == 0) {
                    list.add(14);
                } else {
                    list.add(temp % 10);
                }
                temp = temp / 10;
            }
        }
        // System.out.println(Arrays.toString(list.stream().mapToInt(i -> i).toArray()));
        return list.stream().mapToInt(i -> i).toArray();
    }
}
