package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        File index = new File("index.html");

        try(
            ServerSocket ss = new ServerSocket(3000);
            Socket sc = ss.accept()
        )
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            String request = in.readLine();
            System.out.println(request);
            do {
                request = in.readLine();
                System.out.println(request);
            } while (!request.isEmpty());
            String s = readFile();
            System.out.println("Richiesta terminata. inizio risposta");
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + s.length());
            out.println("");
            out.println(s);
        }

    }

    public static String readFile() throws IOException{
        String index ="";

        try(Stream<String> flusso = Files.lines(Paths.get("/home/informatica/Desktop/demo/src/main/resources/index.html"))){
            List<String> lista = flusso.collect(Collectors.toList());
            
            for (String a : lista) {
                index+=a;
            }
        }
        return index;
    }
}


    
