/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.io.IOException;

/**
 *
 * 
 * 
 * @author Jarvvis
 * 
 */
public class Thread_Boolean extends Thread {

    int count = 1, last;
    boolean boolean_thread;

    
    public void setThread(boolean thread) {
        boolean_thread = thread;
    }

    public void run() {
        for (;;) {
            try {
                if (boolean_thread == true) {
                    count++;
                    this.last = count;

                    if (count % 2 == 0) {
                        System.out.print(count + ", ");
                    }
                } else if (boolean_thread == false) {
                    last--;
                    if (last % 2 == 1) {
                        System.out.print(last + ", ");
                    }
                }
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Thread_Boolean counter = new Thread_Boolean();
        counter.setThread(true);
        counter.start();
        Thread_Boolean t = new Thread_Boolean();

        System.out.println("Bilangan Increment");

        System.in.read();
//        counter.suspend();
//
//        System.out.println("Press any enter to resume the thread counting");
//        System.in.read();
        counter.setThread(false);
        counter.resume();

        System.out.println("Bilangan Decrement");
        System.in.read();
        counter.stop();
    }
}
