package ru.progwards.java1.lessons.Training;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Java_16 {

//    Создайте метод с сигнатурой String createFolder(String name), который создает каталог name (один уровень) в
//    текущей папке и возвращает полный путь родителя текущего каталога

        String createFolder(String name){
            Path path_Par = Paths.get(".");
            new File(name).mkdir();
            Path path = path_Par.resolve(name);
            return path.toAbsolutePath().normalize().getParent().toString();
        }

//    Реализовать метод с сигнатурой boolean replaceF(String name) который заменяет в файле все F на f,
//    в случае ошибки вернуть false. Для реализации пользоваться методами java.nio.file.Files.

    boolean replaceF(String name){
        try {
            String s = Files.readString(Paths.get(name));
            s = s.replace("F", "f");
            Files.writeString(Paths.get(name), s);
            return true;
        }catch (IOException e){
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
//        System.out.println(new Java_16().createFolder("Qwerty"));
        String name = "Java_16.txt";
        Path path = Paths.get("E:/Java/Education/src/ru/progwards/java1/lessons/Training/");
//        Path path = Paths.get(".");
        path = path.resolve(name).toAbsolutePath().normalize();
        System.out.println(path);
//        Files.createFile(path);
        Files.writeString(path, "asdFFhjuelFfldjfhfg\nFFffFFllkdfF");
        System.out.println(new Java_16().replaceF(path.toString()));
    }
}
