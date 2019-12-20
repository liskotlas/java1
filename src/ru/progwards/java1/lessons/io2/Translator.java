package ru.progwards.java1.lessons.io2;

import java.util.Scanner;

public class Translator {
    private String[] inLang;
    private String[] outLang;

    Translator(String[] inLang, String[] outLang) {

        this.inLang = inLang;
        this.outLang = outLang;

    }

    private String reformatString(String string) {
        String reString = ""; // Чистое слово
        String reStringLow = ""; //Чистое слово в нижнем регистре
        String reStringOut = ""; //Слово для возврата
        int resSearch = 0;
//        Очистка слова и перевод в нижний регистр
        char[] word = string.toCharArray();
        for (char c : word) {
            if (Character.isAlphabetic(c)) {
                reString += c;
                reStringLow += Character.toLowerCase(c);
            }
        }
//        Поиск слова в массиве
        for (int i = 0; i < inLang.length; i++) {
            if (reStringLow.compareTo(inLang[i]) == 0) {
                reStringOut = outLang[i];
                resSearch = 1;
                break;
            }
        }
        if (resSearch == 0) {
            return string;
        }
//        Форматирование слова
        // Проверка первой заглавной буквы
        if (reString.substring(0, 1).compareTo(reStringLow.substring(0, 1)) != 0 && reString.substring(0, 1).compareTo(reStringLow.substring(0, 1).toUpperCase()) == 0) {
            reStringOut = reStringOut.substring(0, 1).toUpperCase() + reStringOut.substring(1);
        }

        // Проверка символов после слова
        reStringOut = string.replace(reString, reStringOut);


        return reStringOut;
    }

    public String translate(String sentence) {
        String[] stringArr;
        String string = "";
//Разбите строки на строки и слова
           for (String word: sentence.split(" ")){  //разбитие строки на слова
                string += reformatString(word) + " "; //слово из строки на проверку
            }

        return string;
    }

    public static void main(String[] args) {
        Translator translator = new Translator(new String[]{"привет", "мир"}, new String[]{"hello", "world"});
        String string = "Привет, Мира! Умора25455648";
        String string1 = "Привет, Мир!";
        String string2 = "Привет, \n этот ужасный мир!";
        System.out.println(string + "     " + translator.translate(string));
        System.out.println(string1 + "     " + translator.translate(string1));
        System.out.println(string2 + "     " + translator.translate(string2));
    }
}



