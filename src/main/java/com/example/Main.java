package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        try(
            ServerSocket ss = new ServerSocket(3000);
        )
        {
            do{
                Socket sc = ss.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
                String intestazione = in.readLine();
                System.out.println(intestazione);
                String request;
                do {
                    request = in.readLine();
                    //System.out.println(request);
                } while (!request.isEmpty());
                String file = intestazione.split(" ", 3)[1];
                File index;
                if(file.contains("png") || file.contains("jpg")){
                    index = new File("src/main/resources/dado/img/" + file);
                    System.out.println("png");
                } else {
                    index = new File("src/main/resources/dado/" + file);
                    System.out.println("altro");
                }
                if(index.exists())
                    prova(out,sc,index);

                sc.close();

            } while (true);

        }
    }

    public static void prova(PrintWriter out, Socket sc,File index) throws IOException{
        DataOutputStream outBinary = new DataOutputStream(sc.getOutputStream());
        if (index.exists()) {
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Length: " + index.length() + "");
            out.println("Content-Type: " + getContentType(index) + "");
            out.println("");
            InputStream input = new FileInputStream(index);
            byte[] buf = new byte[8192];
            int n;
            while ((n = input.read(buf)) != -1) {
              outBinary.write(buf, 0, n);
            }
            input.close();
          }

    }

    private static String getContentType(File f) {
        String[] extension = f.getName().split("\\.",2);
        System.out.println(extension[1]);
        switch (extension[1]) {
            case "html":
                System.out.println("ciao");
                return "text/html";
            case "css":
                return "text/css";
            case "png":
                return "image/png";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "js":
                return "text/javascript";        
            default:
                return "application/octet-stream";
        }
      }
}


    
