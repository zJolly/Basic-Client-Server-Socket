package com.mycompany.sk;
import java.io.*;
import java.net.*; 


public class client{
    Socket clientsocket = null;
    DataInputStream in;
    DataOutputStream out;
    int porta = 5678; //porta server
    BufferedReader tastiera;
    
       public void comunica(){
        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("[3] - Sending message to server...");
            String messaggio = tastiera.readLine();
            System.out.println("[4] - Send message: "+ messaggio);
            out.writeBytes(messaggio + "\n");
            System.out.println("[5] - Attend..");
            String ricevuto = in.readLine();
            System.out.println("[6] - Recived message: "+ ricevuto);
        }
        catch(IOException e){
        }
      }
    
    public Socket connetti(){
        try{
        System.out.println("[0] - Try connection at the server...");
        Socket server = new Socket(InetAddress.getLocalHost(), porta);
        System.out.println("[1] - Connection In!");
        in = new DataInputStream(clientsocket.getInputStream());
        out = new DataOutputStream(clientsocket.getOutputStream());
        }
        catch(UnknownHostException e){
         System.err.println("[2] - Undefined Host");
        }
        catch(IOException e){
         System.err.println("[2] - No connection!");
        }
        return clientsocket;
}
    
    public static void main(String args[]) {
        client c = new client();
        c.connetti();
        c.comunica();
    }
}
