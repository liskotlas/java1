package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Censor {


    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        String stringOut = "";
        String reWord = "";

        try (FileReader fileReader = new FileReader(inoutFileName)) {
            Scanner scanner = new Scanner(fileReader);
//            try {
                while (scanner.hasNextLine()) {                     //разбитие на строки
                    String string = scanner.nextLine();
                    for (String word : string.split(" ")) {  //разбитие строки на слова
//                        for (char c : word.toCharArray()) {         //делаем слово чистым
//                            if (Character.isAlphabetic(c)) {
//                                reWord += c;
//                            }
//                            System.out.println(reWord + " - reWord");
//
//                        }

                        for (String arr : obscene) {              //поиск слова в массиве
//                            System.out.println(arr + " - arr");
                            if (word.indexOf(arr) > -1) {
                                for (int i = 1; i<= arr.length(); i++){
                                    reWord += "*";
                                }
                                    word = word.replaceAll(arr, reWord);
                                    reWord = "";
//                                System.out.println(word);
                            }
                        }
                        stringOut += word + " ";
                    }
                    stringOut = stringOut.trim();       //формируем строку вывода
                }
//            }catch (Exception e){
//                throw new CensorException(e.getMessage(), inoutFileName);
//            }
            try (FileWriter fileWriter = new FileWriter(inoutFileName)) {
                fileWriter.write(stringOut);
            } catch (Exception e) {
                throw new CensorException(e.getMessage(), inoutFileName);
            }


        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }


    }

    public static void main(String[] args) {
//        String[] obscene = new String[]{"two", "storey", "day", "write", "house"};
        String[] obscene = null;
        try {
            censorFile("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\io2\\Censor", obscene);
        }catch (CensorException e){
            System.out.println(e.toString());
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
