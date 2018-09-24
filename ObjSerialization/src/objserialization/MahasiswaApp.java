/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objserialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import objserialization.Mahasiswa;
import objserialization.MhsSerial;

/**
 *
 * @author Jarvvis
 */
public class MahasiswaApp {
    public static void main(String[] args) {
        List<Mahasiswa>mhs= new ArrayList<Mahasiswa>();
        MhsSerial mSer= new MhsSerial();
        
        String namaFile= "mahaSerial.ser";
        String nama, nim, asal, kelas, isExit;
        boolean exit=false;
        String pilih;
        
        while(exit !=true){
            System.out.println("----Serialization----");
            System.out.println("1. Insert data");
            System.out.println("2. Update data");
            System.out.println("3. Delete data");
            System.out.println("4. Print data");
            System.out.println("5. Save data");
            System.out.println("6. exit");
            
           Scanner input= new Scanner(System.in);
           pilih= input.nextLine();
           System.out.println("---------------------");
           System.out.println("pilih");
           System.out.println(" ");
           
           switch (pilih) {
                case "1":
                    System.out.println("==== MASUKKAN DATA ===");
                    System.out.print("Nama\t: ");
                    nama = input.nextLine();

                    System.out.print("NIM\t: ");
                    nim = input.nextLine();

                    System.out.print("ASAL\t: ");
                    asal = input.nextLine();

                    System.out.print("KELAS\t: ");
                    kelas = input.nextLine();
                    
                    mhs.add(new Mahasiswa(nim, nama, asal, kelas));
                    break;
                    
                case "2":
                    System.out.print("NIM yang akan diupdate:\t");
                    String updateTarget = input.nextLine();
                    
                    for (int i = 0; i < mhs.size(); i++) {
                        if (mhs.get(i).getNim().equalsIgnoreCase(updateTarget)|| mhs.get(i).getNama().equalsIgnoreCase(updateTarget)) {
                            System.out.println("==== MASUKKAN DATA YANG BARU ===");
                            System.out.print("Nama\t: ");
                            nama = input.nextLine();

                            System.out.print("NIM\t: ");
                             nim = input.nextLine();

                            System.out.print("ASAL\t: ");
                            asal = input.nextLine();

                             System.out.print("KELAS\t: ");
                             kelas = input.nextLine();
                            
                            mhs.set(i, new Mahasiswa(nim, nama, asal, kelas));
                            System.out.println("Data baru disimpan.");
                            break;
                        }
                    }
                    break;
                    
                case "3":
                    System.out.print("NIM yang akan dihapus:\t");
                    String deleteTarget = input.nextLine();
                    
                    for (int i = 0; i < mhs.size(); i++) {
                        if (mhs.get(i).getNim().equalsIgnoreCase(deleteTarget)) {
                            mhs.remove(i);
                            System.out.println("Berhasil menghapus data.");
                            break;
                        }
                    }
                    break;
                    
                case "4":
                    List<Mahasiswa> newList = mSer.deserialize(namaFile);
                    System.out.println("Mahasiswa: " + newList);
                    break;
                    
                case "5":
                    mSer.serialize(mhs, namaFile);
                    System.out.println("Serialization is done!");
                    break;
                    
                case "6":
                    System.out.print("\nExit program (Y/N) ? ");
                    isExit = input.nextLine();
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
