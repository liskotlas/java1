package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {


    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
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
                stringOut = stringOut.trim();       //формируем строку вывода
            }
            try (FileWriter fileWriter = new FileWriter(inoutFileName)) {
                fileWriter.write(stringOut);
            } catch (Exception e) {
                throw new CensorException(e.getMessage(), inoutFileName);
            }


        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }


    }

    public static void main(String[] args) {
        String[] obscene = new String[]{"Java", "Oracle", "Sun", "Microsystems", "puck"};
        try {
            censorFile("E:\\\\Education\\src\\ru\\progwards\\java1\\lessons\\io2\\Censor", obscene);
        }catch (CensorException e){
            System.out.println(e);
        }

    }

    static class CensorException extends Exception {
        public String msg;
        public String fileName;

        @Override
        public String toString() {
            return fileName + ":" + msg;
        }

        public CensorException(String msg, String fileName) {
            super();
            this.msg = msg;
            this.fileName = fileName;


        }

    }
}
