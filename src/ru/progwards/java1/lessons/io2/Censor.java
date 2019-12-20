package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {


    public static void censorFile(String inoutFileName, String[] obscene) {
        String stringOut = "";
        String reWord = "";

        try (FileReader fileReader = new FileReader(inoutFileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {                     //разбитие на строки
                String string = scanner.nextLine();
                for (String word : string.split(" ")) {  //разбитие строки на слова
                    for (char c : word.toCharArray()) {         //делаем слово чистым
                        if (Character.isAlphabetic(c)) {
                            reWord += c;
                        }
                    }

                    for (String arr : obscene) {              //поиск слова в массиве
                        if (arr.compareTo(reWord) == 0) {
                            for (char c : reWord.toCharArray())
                                word = word.replace(String.valueOf(c), "*");    // замена символов слова на символы *
                            break;
                        }
                    }
                    stringOut += word + " ";
                    reWord = "";
                }
                stringOut = stringOut + "\n";       //формируем строку вывода
            }
            try (FileWriter fileWriter = new FileWriter(inoutFileName)) {
                fileWriter.write(stringOut);
            } catch (IOException e) {
                System.out.println(e.toString());
            }


        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }

    public static void main(String[] args) {
        String[] obscene = new String[]{"Java", "Oracle", "Sun", "Microsystems"};
        censorFile("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\io2\\Censor", obscene);
    }

//    class CensorException extends Exception {
//        public String msg;
//        public String error;
//        public CensorException (String fileName, String error){
//            super();
//            this.msg = msg;
//            this.error = error
//
//    @Override
//            public String toString() {
//                String s = getClass().getName();
//                String message = getLocalizedMessage();
//                return (message != null) ? (s + ": " + message) : s;
//            }

}
