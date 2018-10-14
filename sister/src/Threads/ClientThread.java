/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Jarvvis
 */
public class ClientThread extends Thread{
    public static final int SERVICE_PORT = 13;
    String hostname = "localhost";
    InputStream in ;
    BufferedReader bf ;
    @Override
    public void run(){
        try{
            Socket client = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(10000);
            Socket client2 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(10000);
            Socket client3 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client3.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(10000);
            Socket client4 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client4.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(10000);
            Socket client5 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client5.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(10000);
            client.close();
            client2.close();
            client3.close();
            client4.close();
            client5.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new ClientThread();
        t1.start();
    }
}
