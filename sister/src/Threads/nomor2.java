/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author Jarvvis
 */
public class nomor2 extends Thread {
    static int dokter, suster, pasien;
    public void run(){
        
    }
    public static void main(String[] args) {
        for (pasien=0;pasien<10;pasien++){
            System.out.println("Pasien ke "+(pasien+1)+"datang dan diperiksa oleh dokter");
        }
        
        Thread th = new ganjil();
        Thread th1 = new genap();
       
        
        System.out.println("");
        th.start();
        th1.start();
    }
}
