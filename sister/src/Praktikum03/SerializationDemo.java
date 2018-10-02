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
import java.util.List;

/**
 *
 * @author biobii
 */
public class SerializationDemo {
    
    public void serialize(List<Participant> pList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(pList);
        } catch (IOException ex) {
            System.out.println("a problem occured during serialization.\n" + ex.getMessage());
        }
    }
    
    public List<Participant> deserialize(String fileName) {
        List<Participant> pList = null;
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            pList = (List<Participant>) in.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("a problem occured during deserialize %s%n" + fileName);
            System.out.println(e.getMessage());
        }
        
        return pList;
    }
    
}
