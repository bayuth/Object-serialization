/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

//import static Praktikum.pesanBalasan_Client.SERVICE_PORT;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import javax.swing.JTextArea;
/**
 *
 * 
 */
public class pengiriman_Data_TCP {

    public static final int SERVICE_PORT = 13;
    Socket daytime;

    public void kirim(List<Participant_TCP> participants) {
        try {
                String hostname = "localhost";
                this.daytime = new Socket(hostname, SERVICE_PORT); //Membuat Koneksi
                System.out.println("Connection Established");

                daytime.setSoTimeout(2000);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                //String kata = br.readLine();
                System.out.println("Data yang diinputkan : " + participants);

                //proses nulis
                OutputStream os = daytime.getOutputStream();
                PrintStream ps = new PrintStream(os);
                //nulis ke server
                ps.println(participants);//Perlu Println biar datanya kebanya jangan print
               System.out.println("");
                data_diterima();
                
                System.out.println("\n");
                
                os.flush();
                os.close();
                daytime.close();
            
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }

    public void data_diterima() {
        try {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Pesan  dari Server \t : " + br1.readLine());
            System.out.println("");
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
