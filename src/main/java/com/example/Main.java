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

        out.println("Ciao! questa e' una chat per uscire digita 2 per exit, e 1 per continuiare a chattare!");

        int scelta = 2;
        int stop = 0;

        do{

            out.println("\n==============================");
            out.println("        MENU PRINCIPALE       ");
            out.println("==============================");
            out.println("1  Continua a chattare");
            out.println("2  Esci dalla chat");
            out.println("------------------------------");

            String line = in.readLine();
            int numero = Integer.parseInt(line); 
            System.out.println(line);
            scelta = numero;

            switch (scelta) {
                case 1:
                    // blocco di istruzioni
                    out.println("digita il messaggio che vuoi mandare: ");

                    String stringa = in.readLine();
                    System.out.println(stringa);

                    String scan = scanner.next();
                    out.print("> ");
                    out.println(scan);
                    break; // interrompe lo switch
                case 2:
                    // altro blocco
                    stop = 1;
                    break;
                default:
                    // eseguito se nessun case corrisponde
                    out.println("Devi sceglere una delle precedenti opzioni");
                    break;
            }

        }while(stop == 0);

        scanner.close();
        ss.close();
        
    }
}        