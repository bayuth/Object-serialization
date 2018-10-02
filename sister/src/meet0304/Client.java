/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet0304;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Client {
    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;
    
    public static void main(String[] args) throws SocketException, IOException {
        String fileName = "mahasiswa.ser";
        String nim, nama, asal, kelas, isExit;
        String choice;
        
        boolean exit = false;
        
        List<Mahasiswa> newLists = new ArrayList<Mahasiswa>();
        SerializationDemo demo = new SerializationDemo();
        
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);
        
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while (!exit) {
            System.out.println("\n==== PILIH AKSI ===");
            System.out.println("1 Insert");
            System.out.println("2 Update");
            System.out.println("3 Delete");
            System.out.println("4 Print");
            System.out.println("5 Save");
            System.out.println("6 Exit");
            
            Scanner scan = new Scanner(System.in);
            System.out.print("\nPilih (angka) --> ");
            choice = scan.nextLine();
            System.out.println("");
            
            switch (choice) {
                case "1":
                    System.out.println("==== MASUKKAN DATA ===");
                    System.out.print("NIM\t: ");
                    nim = scan.nextLine();

                    System.out.print("NAMA\t: ");
                    nama = scan.nextLine();

                    System.out.print("ASAL\t: ");
                    asal = scan.nextLine();

                    System.out.print("KELAS\t: ");
                    kelas = scan.nextLine();
                    
                    newLists.add(new Mahasiswa(nim, nama, asal, kelas));
                    break;
                    
                case "2":
                    System.out.print("NIM yang akan diupdate:\t");
                    String updateTarget = scan.nextLine();
                    
                    for (int i = 0; i < newLists.size(); i++) {
                        if (newLists.get(i).getNim().equalsIgnoreCase(updateTarget)) {
                            System.out.println("==== MASUKKAN DATA BARU ===");
                            System.out.print("NIM\t: ");
                            nim = scan.nextLine();

                            System.out.print("NAMA\t: ");
                            nama = scan.nextLine();

                            System.out.print("ASAL\t: ");
                            asal = scan.nextLine();

                            System.out.print("KELAS\t: ");
                            kelas = scan.nextLine();
                            
                            newLists.set(i, new Mahasiswa(nim, nama, asal, kelas));
                            System.out.println("Data baru disimpan.");
                            break;
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("NIM yang akan dihapus:\t");
                    String deleteTarget = scan.nextLine();
                    
                    for (int i = 0; i < newLists.size(); i++) {
                        if (newLists.get(i).getNim().equalsIgnoreCase(deleteTarget)) {
                            newLists.remove(i);
                            System.out.println("Berhasil menghapus data.");
                            break;
                        }
                    }
                    break;
                    
                case "4":
                    ByteArrayOutputStream bouts = new ByteArrayOutputStream();
                    PrintStream pouts = new PrintStream(bouts);

                    pouts.print(newLists);

                    byte[] barrays = bouts.toByteArray();

                    DatagramPacket packets = new DatagramPacket(barrays, barrays.length, addr, SERVICE_PORT);
                    socket.send(packets);

                    byte[] recbufs = new byte[BUFSIZE];
                    DatagramPacket receivePackets = new DatagramPacket(recbufs, BUFSIZE);

                    boolean timeouts = false;

                    try {
                        socket.receive(receivePackets);
                    } catch (InterruptedIOException e) {
                        timeouts = true;
                    }

                    if (!timeouts) {
                        ByteArrayInputStream bin = new ByteArrayInputStream(
                                receivePackets.getData(),
                                0,
                                receivePackets.getLength()
                        );

                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                        System.out.println(reader2.readLine());
                    } else {
                        System.out.println("Packet lost!");
                    }
//                    byte[] readLists = demo.des(fileName);
//                    System.out.println(new String(readLists));
                    break;
                    
                case "5":
                    ByteArrayOutputStream bout = new ByteArrayOutputStream();
                    PrintStream pout = new PrintStream(bout);

                    pout.print(newLists);

                    byte[] barray = bout.toByteArray();

                    DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
                    System.out.println("Sending packet to : " + hostname);
                    socket.send(packet);

                    byte[] recbuf = new byte[BUFSIZE];
                    DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);

                    boolean timeout = false;

                    try {
                        socket.receive(receivePacket);
                    } catch (InterruptedIOException e) {
                        timeout = true;
                    }

                    if (!timeout) {
                        System.out.println("Packet received!");
                        System.out.println("Details : " + receivePacket.getAddress());

                        ByteArrayInputStream bin = new ByteArrayInputStream(
                                receivePacket.getData(),
                                0,
                                receivePacket.getLength()
                        );

                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                        System.out.println(reader2.readLine());
                    } else {
                        System.out.println("Packet lost!");
                    }
                    System.out.println("Data dikirim ke server!");
                    break;
                    
                case "6":
                    System.out.print("\nExit program (Y/N) ? ");
                    isExit = scan.nextLine();
                    System.out.println("");

                    if (isExit.equalsIgnoreCase("Y")) {
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
