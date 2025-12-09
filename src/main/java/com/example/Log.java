package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Log {
    private File log;
    private FileWriter logW;
    public Log(){
        log  = new File("log.txt");
    }


    public void createLog(String message, String tName) throws IOException{
        if (!log.exists()) {
            log.createNewFile();
        }
    
        logW = new FileWriter(log, true);
        logW.write(tName + ": " + message + "\n");
        logW.close();
   }

    public void closeLog() throws IOException{
        logW.close();
    }

    public boolean exists(){
        return log.exists();
    }

    public void remove(){
        log.delete();
    }

    public void readLog(PrintWriter out,String tName) throws IOException{
        

        try(Stream<String> flusso = Files.lines(Paths.get("log.txt"))){
            List<String> lista = flusso.collect(Collectors.toList());
            
            for (String a : lista) {

                if(a.charAt(0) == tName.charAt(0)){
                    out.println("Tu:" + a.substring(2));
                } else {
                    out.println("Client "+ tName + ": " + a.substring(2));
                }
            }
        }
    }
}
