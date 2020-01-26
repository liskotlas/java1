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
    private List<Path> fileList(String start){
        List<Path> fileList = new ArrayList<>();
        Path pathFile = Paths.get(start);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*");
        try {
            Files.walkFileTree(pathFile, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
//                    if (pathMatcher.matches(pathFile.relativize(path))) {
                    if (pathMatcher.matches(path)) {
                        fileList.add(path);
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
            if (Files.getAttribute(file1, "lastModifiedTime").equals(Files.getAttribute(file2, "lastModifiedTime")) && Files.getAttribute(file1, "size").equals(Files.getAttribute(file2, "size"))) {
                if (Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2))) {
//                    System.out.println("Сошлись)");
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
        List<Path> tmpFileList = fileList(startPath);

        for (int i = 0; i < tmpFileList.size(); i++) {
            Path file1 = tmpFileList.get(i);
            List<String> filePathList = new ArrayList<>();
            for (int f = i+1; f < tmpFileList.size(); f++) {
                Path file2 = tmpFileList.get(f);
                if (file1.getFileName().compareTo(file2.getFileName()) == 0 && fullFiltr(file1, file2)) {
                        filePathList.add(file1.toString());
                        filePathList.add(file2.toString());
                        tmpFileList.remove(f);
                }
            }
            if (filePathList.size() !=0){
                result.add(filePathList);
            }
        }
        return result;
    }


    public static void main(String[] args){
        FindDuplicates findDuplicates = new FindDuplicates();
        for (var pass : findDuplicates.findDuplicates("e:/Dir")) {

            for (String s : pass) {
                System.out.print(s + ",  ");
            }
            System.out.println("\n");
        }
    }
}
