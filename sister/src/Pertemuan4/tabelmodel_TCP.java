/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tabelmodel_TCP extends AbstractTableModel {

    private List<Participant_TCP> listMahasiswa = new ArrayList<>();

    public void insert(Participant_TCP mahasiswaBaru) {
        listMahasiswa.add(mahasiswaBaru);
        fireTableDataChanged();
    }

    public void update(int index, Participant_TCP mahasiswaUpdate) {
        listMahasiswa.set(index, mahasiswaUpdate);
        fireTableDataChanged();
    }

    public void delete(int index) {
        listMahasiswa.remove(index);
        fireTableDataChanged();
    }

    public Participant_TCP getMahasiswa(int index) {
        return listMahasiswa.get(index);
    }

    public void setListMahasiswa(List<Participant_TCP> listMahasiswaBaru) {
        listMahasiswa = listMahasiswaBaru;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listMahasiswa.size();
    }

   @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
//            case 0:
//                return rowIndex + 1;
            case 0:
                return listMahasiswa.get(rowIndex).getNim();
            case 1:
                return listMahasiswa.get(rowIndex).getNama();
            case 2:
                return listMahasiswa.get(rowIndex).getJurusan();
            case 3:
                return listMahasiswa.get(rowIndex).getAsal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
//            case 0:
//                return "No";
            case 0:
                return "NIM";
            case 1:
                return "Nama";
            case 2:
                return "Jurusan";
            case 3:
                return "Asal";
            default:
                return null;
        }
    }
}
