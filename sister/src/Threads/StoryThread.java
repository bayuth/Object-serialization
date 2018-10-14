/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author Jarvvis
 * 
 */
public class StoryThread extends Thread{
    String petugas;
    int pasien;
    
    StoryThread(String p){
        petugas = p;
    }
    @Override
    public void run(){
        try{
            for(;;){
                if(petugas.equals("dokter")){
                    pasien++;
                    System.out.println("Pasien ke "+pasien+" sedang ditangani oleh "+petugas);
                    Thread.sleep(1000);
                    if(pasien>=10){
                        System.out.println("Menuju ke perawat....");
                        Thread.sleep(5000);
                        petugas="perawat";
                        pasien=0;
                    }
                }else if(petugas.equals("perawat")){
                    pasien++;
                    if(pasien<=5){
                        System.out.println("Pasien ke "+pasien +" sedang dirawat oleh "+petugas);
                        Thread.sleep(1000);
                    }else if(pasien==5){
                        System.out.println("Menunggu "+petugas+" selesai menangani "+pasien+" pasien");
                        Thread.sleep(5000);
                    }else if(pasien>5&&pasien<=10){
                        System.out.println("Pasien ke "+pasien+" sedang dirawat oleh "+petugas);
                        Thread.sleep(1000);
                    }else{
                        System.out.println("Pasien mengantri untuk membayar biaya perobatan di bagian "+petugas);
                        Thread.sleep(10000);
                        petugas="kasir";
                        pasien = 0;
                    }
                }else if(petugas.equals("kasir")){
                    pasien++;
                    System.out.println("Pasien ke "+pasien+" sedang membayar biaya di bagian "+petugas);
                    Thread.sleep(1000);
                    if(pasien>=10){
                        System.out.println("Have a nice day....");
                        break;
                    }
                }
            }
        }catch(InterruptedException ie){
            
        }
    }
    public static void main(String[] args) {
        Thread dokter = new StoryThread("dokter");
        dokter.start();
    }
}
