/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author biobii
 */
public class ScanIP {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        System.out.println("=============");
        System.out.println("M. Robih T. Z");
        System.out.println("16650012");
        
        String network = "192.168.1.";
        
        for (int i = 1; i <= 255; i++) {
            InetAddress ia = InetAddress.getByName(network + i);
            
            if (ia.isReachable(5000)) {
                System.out.println(ia.getHostAddress() + " is reachable");
            } else {
                System.out.println(ia.getHostAddress() + " is unreachable");
            }
        }
    }
}
