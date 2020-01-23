package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;


public class FilesSelect {


    public void selectFiles(String inFolder, String outFolder, List<String> keys){
        Path folderIn = Paths.get(inFolder);

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try {
            Files.walkFileTree(folderIn, new SimpleFileVisitor<Path>() {


                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {

                    String s;
                        if (pathMatcher.matches(path)) {
                            if ((s = fileFiltr(path, keys)) != "") {
                                Path folderOut = Paths.get(outFolder).resolve(s);
                                try {
                                    Files.createDirectories(folderOut);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Path newPath = folderOut.resolve(path.getFileName());
                                try {
                                    Files.copy(path, newPath, StandardCopyOption.REPLACE_EXISTING);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
//                    }
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
    }

    private  String fileFiltr (Path pathFile, List<String> keyList){
        String fileText = null;
        try {
            fileText = Files.readString(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : keyList){
            if (fileText.contains(key)){
                return key;
            }
        }
            return "";
    }

    public static void main(String[] args) {
        String inString = "E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\files\\In";
        String outString = "E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\files\\Out";
        List<String> keys = List.of("1", "2");
        FilesSelect filesSelect = new FilesSelect();
        filesSelect.selectFiles(inString, outString, keys);


    }
}
