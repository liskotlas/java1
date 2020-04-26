package ru.progwards.java2.lessons.Training;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Java2_15 {

    public static void main(String[] args) {
//        try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)){
//        try (Socket socket = new Socket("vk.com", 80)){
//
//            String request =    "GET / HTTP/1.1 \n" +
//                                "host: vk.com\n\n";
//
//
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
//
//            PrintWriter pw = new PrintWriter(os);
//            pw.println(request);
//            pw.flush();
//
//            Scanner scanner = new Scanner(is);
//
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        try (ServerSocket serverSocket = new ServerSocket(80)) {

            Socket server = serverSocket.accept();


            InputStream is = server.getInputStream();
            OutputStream os = server.getOutputStream();
            Scanner scanner = new Scanner(is);

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                PrintWriter pr = new PrintWriter(os);
                pr.println("Echo: " + str);
                if (str.compareTo("EXIT") == 0) {
                    break;
                }
            }


            PrintWriter pr = new PrintWriter(os);
            pr.println(new Date());
            pr.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
