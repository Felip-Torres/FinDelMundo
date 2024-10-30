/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.TablasAbstractas;

import com.mycompany.projectofinal.dto.Intent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alumne
 */
public class TablasIntentos extends AbstractTableModel{
    private List<Intent> listIntent;
    private String[] columnes = {"Id", "IdUsuari", "IdEjercicio", "Inici", "Fi", "Videofile"};

    public TablasIntentos(List<Intent> listIntent) {
        this.listIntent = listIntent;
    }
    
    @Override
    public int getRowCount() {
        return listIntent.size();
    }

    @Override
    public int getColumnCount() {
        return  columnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 ->{
                return listIntent.get(rowIndex).getId();
            }
                
            case 1->{
                return listIntent.get(rowIndex).getIdUsuari();
            }
            case 2 ->{
                return listIntent.get(rowIndex).getIdEjercicio();
            }
                
            case 3->{
                return listIntent.get(rowIndex).getInici();
            }
            case 4 ->{
                return listIntent.get(rowIndex).getFi();
            }
                
            case 5->{
                return listIntent.get(rowIndex).getVideofile();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnes[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    public int getColumNum(String column){
        for (int i=0; i<columnes.length;i++)if(columnes[i].equals(column))return i;
        return -1;
    }
}
