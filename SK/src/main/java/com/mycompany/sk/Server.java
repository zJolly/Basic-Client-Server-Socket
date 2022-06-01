package com.mycompany.sk;
import java.io.*;
import java.net.*;

public class Server{
    ServerSocket server = null;
    Socket client = null;
    DataInputStream in;
    DataOutputStream out;
    int porta = 5678; //porta server
    
    public void comunica(){
        try{
            System.out.println("[3] - Attend message to client...");
            String letto = in.readLine();
            System.out.println("[4] - Message in: "+ letto);
            String risposta = letto.toUpperCase();
            System.out.println("[5] - Message send to client!" + risposta);
            out.writeBytes(risposta + "\n");
            client.close();
        }
        catch(IOException e){
        }
    
}
    
    public Socket attendi(){
        try{
            System.out.println("[0] - Server start");
            server = new ServerSocket(porta); //Inizializzazione
            System.out.println("[1] - Server starting, on port: " + porta);
            client = server.accept(); //Si mette in ascolto   
            System.out.println("[2] - Connection in !");
            server.close(); //Evitare connessioni multiple
            
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
    }
    catch(IOException e){
    }
    return client;
    }


    public static void main(String[] args){
        Server s = new Server();
        s.attendi();
        s.comunica();

    }
}