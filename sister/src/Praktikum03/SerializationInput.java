/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author biobii
 */
public class SerializationInput {
    
    public static void main(String[] args) {
        String fileName = "customSerialize.ser";
        String firstName, lastName, selectExit;
        int age;
        
        boolean exit = false;
        
        List<Participant> participants = new ArrayList<Participant>();
        
        while (!exit) {
            System.out.println("==== Masukkan Data ===");
            Scanner scan = new Scanner(System.in);

            System.out.print("Nama depan\t: ");
            firstName = scan.nextLine();

            System.out.print("Nama belakang\t: ");
            lastName = scan.nextLine();
            
            System.out.print("Usia\t: ");
            age = Integer.parseInt(scan.nextLine());
            
            participants.add(new Participant(firstName, lastName, age));
            
            System.out.print("Exit program (Y/N) ? ");
            selectExit = scan.nextLine();
            System.out.println("");
            
            if (selectExit.equalsIgnoreCase("Y")) {
                exit = true;
            }
        }
        
        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, fileName);
        System.out.println("Serialization is done!");
        
        System.out.println("\n==== Deserialize object ====");
        List<Participant> newList = demo.deserialize(fileName);
        System.out.println("Lists: " + newList);
    }
    
}
