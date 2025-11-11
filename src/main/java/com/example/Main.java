package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);   //istanzio lo scanner per acquisire valori da tastieri

        
        ServerSocket ss = new ServerSocket(6000);   // Step 1: Create a server socket listening on port 3000
        Socket s = ss.accept();    // Step 2: Accept a client connection
        System.out.println("Client connesso!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));  // Step 3: Create input stream to read data from client
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);   // Step 4: Create output stream to send data to client

        out.println("Ciao! questa e' una chat per uscire digita exit!");

        String var = "";

        do{
            String stringa = in.readLine();
            System.out.println(stringa);

            if(stringa.toLowerCase().equals("exit")){
                var = "exit";
                break;
            }

            String scan = scanner.next();
            out.println(scan);

            if(scan.toLowerCase().equals("exit")){
                var = "exit";
                break;
            }

        }while(!var.equals("exit"));

        scanner.close();
        ss.close();
        
    }
}        