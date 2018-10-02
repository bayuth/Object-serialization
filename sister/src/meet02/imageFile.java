/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet02;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author biobii
 */
public class imageFile {

    private Image selectedImage;
    private String file = "";

    public static void main(String[] args) {
        imageFile app = new imageFile();
        app.readImage();
    }

    public void readImage() {
        try {
            FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            this.file = dialog.getDirectory() + dialog.getFile();

            File imageFile = new File(file);
            this.selectedImage = ImageIO.read(imageFile);

            InputStream is = new BufferedInputStream(new FileInputStream(file));
            this.selectedImage = ImageIO.read(is);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }

        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(this.selectedImage));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
        try {
            Thread.sleep(2000);
            this.copyImage(this.file);
        } catch (Exception e) {
            
        }
        
        System.exit(0);
    }

    public void copyImage(String file) {
        try {
            File copy = new File("/home/biobii/Documents/copied.jpg");
            ImageIO.write(ImageIO.read(new File(file)), "jpg", copy);

            JOptionPane.showMessageDialog(null, "File berhasil disalin!");
            JOptionPane.showMessageDialog(null, "Output: /home/biobii/Documents/copied.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
