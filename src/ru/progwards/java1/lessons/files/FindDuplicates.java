package ru.progwards.java1.lessons.files;

//В заданном каталоге и его подкаталогах найти файлы, точно совпадающие по названию (и расширению), дате-времени последнего изменения,
// размеру и по содержимому. Сигнатура метода public List<List<String>> findDuplicates(String startPath),
// результат - список, содержащий списки строк с именами и полными путями совпадающих файлов.

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FindDuplicates {

    //    Создание Map с именами файлов по результатам сравнения файлов
    private Map<Path, ArrayList<Path>> fileList(String start){
        Map<Path, ArrayList<Path>> fileList = new HashMap<>();
        Path pathFile = Paths.get(start);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*");
        try {
            Files.walkFileTree(pathFile, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(pathFile.relativize(path))) {
                        if (fileList.containsKey(path.getFileName()) && fullFiltr(fileList.get(path.getFileName()).get(0), path)) {
                            fileList.get(path.getFileName()).add(path);
                            return FileVisitResult.CONTINUE;
                        }
                        ArrayList<Path> tmpPath = new ArrayList<>();
                        tmpPath.add(path);
                        fileList.putIfAbsent(path.getFileName(), tmpPath);
                        return FileVisitResult.CONTINUE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }


    // сравнение файлов по атрибутам и содержимому
    private boolean fullFiltr(Path file1, Path file2){
        try {
            if (Files.getAttribute(file1, "lastModifiedTime") == Files.getAttribute(file2, "lastModifiedTime") && Files.getAttribute(file1, "size") == Files.getAttribute(file2, "size")) {
                if (Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2))) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //    обработка Map и вывод результата
    public List<List<String>> findDuplicates(String startPath){
        List<List<String>> result = new ArrayList<>();
        for (var entry : fileList(startPath).entrySet()) {
            if (entry.getValue().size() > 0) {
                List<String> stringPath = new ArrayList<>();
                for (Path path : entry.getValue()) {
                    stringPath.add(path.toString());
                }
                result.add(stringPath);
            }
        }
        return result;
    }


    public static void main(String[] args){
        FindDuplicates findDuplicates = new FindDuplicates();
        for (var pass : findDuplicates.findDuplicates("e:/Java/Education/src/ru/progwards/java1/lessons")) {
            for (String s : pass) {
                System.out.println(s);
            }
//            System.out.println(entry.getValue().getClass());

        }
    }

}
