/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objserialization;
import java.io.Serializable;

/**
 *
 * @author Jarvvis
 */
public class Mahasiswa implements Serializable{
    private String nama;
    private String nim;
    private String asal;
    private String kelas;
    
    public Mahasiswa(String nama, String nim, String asal, String kelas){
        this.nama= nama;
        this.nim= nim;
        this.asal= asal;
        this.kelas= kelas;
    }
    
    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public String getAsal(){
        return asal;
    }
    public String getKelas(){
        return kelas;
    }
    
     @Override
    public String toString() {
        return nama + " " + nim + " "+asal+" "+kelas;
    }
    
}

