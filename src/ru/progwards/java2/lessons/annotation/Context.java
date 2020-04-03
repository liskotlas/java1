package ru.progwards.java2.lessons.annotation;

import app.service.impl.AccountServiceImpl;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.HashMap;

public class Context {

    Class accountServiceClass = AccountServiceImpl.class;


    static HashMap<String, Object> classHashMap = new HashMap<>();

    public static void initialize(String packageName) {


        Path pathStart = null;
        String path = "";
        Enumeration enumeration = null;

//        Поиск файлов .class
        try {
            enumeration = ClassLoader.getSystemResources(packageName);
            while (enumeration.hasMoreElements()) {
                path = enumeration.nextElement().toString().substring(6);
                pathStart = Paths.get(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Проверка найденных классов

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.class");

        try {
            Files.walkFileTree(pathStart, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {


                    if (pathMatcher.matches(path)) {
                        char a = '.';
                        char b = '\\';
                        char c = '/';
                        String in = packageName.replace(c, a);

                        String out = path.toString().replace(b, a).substring(0, path.toString().length() - 6);
                        out = out.substring(out.indexOf(in));

                        try {
                            Class aClass = Class.forName(out);

                            if (aClass.getDeclaredAnnotation(Dependency.class) != null) {
                                System.out.println("Нашел!");
                                addList(aClass);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
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
    }

    private static void addList(Class aClass) {

        try {
            classHashMap.put(((Dependency) aClass.getDeclaredAnnotation(Dependency.class)).name(), aClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String name) {
        if (classHashMap.containsKey(name)) {

            return classHashMap.get(name);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println();

        initialize("ru/progwards/java2/lessons/annotation/app");
    }
}
