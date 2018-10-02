/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet0304;

import Praktikum03.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import meet0304.Mahasiswa;
import meet0304.SerializationDemo;

/**
 *
 * @author biobii
 */
public class SerializationObject {
    
    public static void main(String[] args) {
        String fileName = "mahasiswa.ser";
        String nim, nama, asal, kelas, isExit;
        String choice;
        
        boolean exit = false;
        
        List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
        SerializationDemo demo = new SerializationDemo();
        
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
                    
                    mahasiswa.add(new Mahasiswa(nim, nama, asal, kelas));
                    break;
                    
                case "2":
                    System.out.print("NIM yang akan diupdate:\t");
                    String updateTarget = scan.nextLine();
                    
                    for (int i = 0; i < mahasiswa.size(); i++) {
                        if (mahasiswa.get(i).getNim().equalsIgnoreCase(updateTarget)) {
                            System.out.println("==== MASUKKAN DATA BARU ===");
                            System.out.print("NIM\t: ");
                            nim = scan.nextLine();

                            System.out.print("NAMA\t: ");
                            nama = scan.nextLine();

                            System.out.print("ASAL\t: ");
                            asal = scan.nextLine();

                            System.out.print("KELAS\t: ");
                            kelas = scan.nextLine();
                            
                            mahasiswa.set(i, new Mahasiswa(nim, nama, asal, kelas));
                            System.out.println("Data baru disimpan.");
                            break;
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("NIM yang akan dihapus:\t");
                    String deleteTarget = scan.nextLine();
                    
                    for (int i = 0; i < mahasiswa.size(); i++) {
                        if (mahasiswa.get(i).getNim().equalsIgnoreCase(deleteTarget)) {
                            mahasiswa.remove(i);
                            System.out.println("Berhasil menghapus data.");
                            break;
                        }
                    }
                    break;
                    
                case "4":
                    List<Mahasiswa> newList = demo.deserialize(fileName);
                    System.out.println("Mahasiswa: " + newList);
                    break;
                    
                case "5":
                    demo.serialize(mahasiswa, fileName);
                    System.out.println("Serialization is done!");
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
