/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jarvvis
 */
public class Thread_Array extends Thread {

    static int i = 0;
    static int[] Array1 = {6, 9, 1, 2, 3, 5};
    static int[] Array2 = {7, 11, 6, 4, 3, 1};
    static int[] Array3 = {5, 4, 3, 2, 1, 12};
    static int[] jumlah = new int[6];
    private int A;
    private int B;
    private int C;
    private String threadName;

    public Thread_Array(String name) {
        threadName = name;
    }

    public void setIndeks(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

//    public int getIndeks() {
//        return this.Indeks;
//    }
    public void run() {
//   
        int jumlah = A + B + C;
        System.out.print(threadName+ " coba  \t ") ;
        System.out.println(A + " + " + B + " + " + C + " = " + jumlah);

    }

   

    public static void main(String[] args) {
        for (i = 0; i < 3; i++) {
            System.out.print("Array 1 \t : ");
            for (i = 0; i < 6; i++) {
                System.out.print(Array1[i] + ", ");
            }
            System.out.print("\nArray 2 \t : ");
            for (i = 0; i < 6; i++) {
                System.out.print(Array2[i] + ", ");
            }
            System.out.print("\nArray 3 \t : ");
            for (i = 0; i < 6; i++) {
                System.out.print(Array3[i] + ", ");
            }
            System.out.println("");
        }
        for (i = 0; i < 1; i++) {
            for (i = 0; i < 2; i++) {
                System.out.print("\t ");
            }
            for (i = 0; i < 20; i++) {
                System.out.print("-");
            }
            System.out.println("+");
        }

        System.out.println("\nJumlah \t\t : ");
        for (int a = 0; a < 6; a++) {
            Thread_Array th = new Thread_Array("Thread " + a);
            th.setIndeks(Array1[a], Array2[a], Array3[a]);
            th.start();
        }
    }

}
