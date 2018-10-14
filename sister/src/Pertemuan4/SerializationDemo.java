/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pertemuan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
/**
 *
 * 
 */
public class SerializationDemo {
      public void serialize(String pList, String fileName){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(pList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String deserealize(String fileName){
        String pList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            pList = String.valueOf(in.readObject());
            
        } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
        }
        return pList;
    }
}
