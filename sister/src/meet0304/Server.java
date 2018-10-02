/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet0304;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Server {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 4069;

    private DatagramSocket socket;

    Server() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("SERVER ACTIVE ON PORT: " + socket.getLocalPort());
        } catch (Exception e) {
            System.err.println("Unable to bind port");
        }
    }

    public void serviceClients() {
        byte[] buffer = new byte[BUFSIZE];

        for (;;) {
            try {
                
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
                socket.receive(packet);

                if (packet.getLength() == 1) {
                    byte[] readbuf = new byte[BUFSIZE];
                    readbuf = this.deserialize("mahasiswa.ser");
                    packet = new DatagramPacket(readbuf, readbuf.length, packet.getAddress(), packet.getPort());
                } else {
                    this.serialize(packet.getData(), "mahasiswa.ser");

                    System.out.println("Packet received from "
                            + packet.getAddress() + " : "
                            + packet.getPort()
                            + " of length " + packet.getLength()
                    );
                }
                socket.send(packet);
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    public void serialize(byte[] dataPacket, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(dataPacket);
        } catch (IOException ex) {
            System.out.println("a problem occured during serialization.\n" + ex.getMessage());
        }
    }
    
    public byte[] deserialize(String filename) {
        byte[] pList = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            pList = (byte[]) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("a problem occured during deserialize %s%n" + filename);
            System.out.println(e.getMessage());
        }

        return pList;
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.serviceClients();
    }
}
