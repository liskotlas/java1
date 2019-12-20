package ru.progwards.java1.lessons.Training;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Java_10 {
    public void doSomething(int n) throws IOException {

    }

    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally executed");
        }
    }

    public static void doExceptions(int n) throws Throwable {
        Throwable suppressed = null;
        try {
            System.out.println("doExceptions 1");
            if (n == 0)
                throw new Exception("Exception in try");
            System.out.println("doExceptions 2");
        } catch (Throwable t) {
            suppressed = t;
            throw t;
        } finally {
            try {
                throw new Exception("Exception in finally");
            } catch (Throwable t) {
                if (suppressed != null)
                    t.addSuppressed(suppressed);
                throw t;
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        try {
//            doExceptions(1);
//        } catch (Throwable e) {
//            System.out.println(e.getMessage());
//            for (Throwable t: e.getSuppressed())
//                System.out.println(t.getMessage() + " (suppressed)");
//        }
//    }


    public void scanLines() {
        try (Scanner scanner = new Scanner(System.in)) {
            ;
            while (true) {

                String s = scanner.nextLine();
                if (s.contains("/stop")) {
                    break;
                }
                if (s.contains("Привет")) {
                    System.out.println("Здравствуйте!");
                    continue;
                }
                if (s.contains("как дела")) {
                    System.out.println("Хорошо");
                    continue;
                }
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public String invertWords(String sentence) {
        String result = "";
        if ("".equals(sentence)) {
            return "";
        }
        try (Scanner scanner = new Scanner(sentence)) {
            while (scanner.hasNext()) {
                result = "." + scanner.next() + result;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result.substring(1);
    }


//    public static void main(String[] args) {
//        Java_10 one = new Java_10();
//        System.out.println(one.invertWords(""));
//    }

    public String setStars(String filename) {
        String s = "";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw")) {
//            System.out.println(randomAccessFile.length());
            for (int i = 9; i < randomAccessFile.length(); i += 10) {
                randomAccessFile.seek(i);
//                System.out.println(randomAccessFile.readByte());
                int a = randomAccessFile.readByte();
//                System.out.println((char)a);
                s = s + (char) a;
                randomAccessFile.seek(i);
                randomAccessFile.writeByte(42);
            }
        } catch (IOException e) {
            new IOException(e.getMessage());
        }

        return s;
    }

    public static void main(String[] args) {
        Java_10 two = new Java_10();
        System.out.println(two.setStars("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\Training\\Star.txt"));

    }
}
