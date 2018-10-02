/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meet02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

/**
 *
 * @author biobii
 */
public class FileStream {
    
    private String path;
    private String newFile;
    private String existingFile;
    
    private InputStream input;
    private OutputStream output;
    
    private String data = "";
    
    public FileStream() {
        this.path = "/home/biobii/Documents/";
    }
    
    public void setNewFileDestination(String newFile) {
        this.newFile = this.getPath() + newFile;
    }
    
    public String getNewFileDestination() {
        return this.newFile;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public String getExistingFile(String file) {
        this.existingFile = this.getPath() + file;
        return this.existingFile;
    }
    
    public void copyData(String existingFile) {
        try {
            input = new FileInputStream(this.getExistingFile(existingFile));
            output = new FileOutputStream(this.getNewFileDestination());
            
            int temp = input.read();
            while (temp != -1) {
                this.data += (char) temp;
                temp = input.read();
            }
            
            for (int i = 0; i < this.data.length(); i++) {
                output.write((byte) this.data.charAt(i));
            }
            
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        FileStream app = new FileStream();
        
        app.setNewFileDestination("newFile.txt");
        app.copyData("existingFile.txt");
    }
}
