/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author biobii
 */
public class ParticipantSer implements Serializable {
    
    private String firstName;
    private String lastName;
    private int age;
    
    public ParticipantSer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public void printData() {
        System.out.println("Nama\t: " + firstName + " " + lastName);
        System.out.println("Usia\t: " + age);
    }
    
    public void saveObject(ParticipantSer obj) {
        try {
            FileOutputStream fos = new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println("a problem occured during serialize.\n "
                + e.getMessage());
        }
    }
    
    public void readObject(ParticipantSer obj) {
        try {
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            obj = (ParticipantSer) ois.readObject();
            obj.printData();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("a problem occured during deserialize.\n" + ex);
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        ParticipantSer is = new ParticipantSer("Dee", "Aja", 22);
        is.saveObject(is);
        is.readObject(is);
    }
    
}
