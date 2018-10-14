/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author Jarvvis
 */
public class ganjil extends Thread {
static int dokter, suster,pasien;
   
 
    public void run() {
        for (int i = 1; i < 11; i+=2) {
            System.out.println("Perawat 2 merawat pasien ke " + i + " ");
            System.out.println("Pasien "+i+" pergi ke kasir");
            System.out.println("");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {

        }
    }
}}
