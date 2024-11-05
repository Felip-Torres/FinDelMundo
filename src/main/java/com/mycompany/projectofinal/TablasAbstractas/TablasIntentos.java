/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.TablasAbstractas;

import com.mycompany.projectofinal.dto.Intent;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Alumne
 */
public class TablasIntentos extends AbstractTableModel{
    private List<Intent> listIntent;
    private String[] columnes = {"Id", "IdEjercicio", "Inici", "Estado"};

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
                
            case 1 ->{
                return listIntent.get(rowIndex).getIdEjercicio();
            }
                
            case 2->{
                return listIntent.get(rowIndex).getInici();
            }
            
            case 3->{
                return listIntent.get(rowIndex).getEstado();
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
    
    public Intent getIntent(int row){
        return listIntent.get(row);
    }
    
    // Renderer para cambiar el color de fondo de las filas según el estado
    public static class EstadoTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener el modelo de datos y el valor del estado
            TablasIntentos model = (TablasIntentos) table.getModel();
            String estado = (String) model.getValueAt(row, model.getColumNum("Estado"));

            // Configurar el color de fondo según el estado
            if (!isSelected) { // Solo cambiar color si no está seleccionada
                switch (estado) {
                    case "Aprobado" -> cell.setBackground(new Color(100, 255, 100)); // Verde 
                    case "Suspendido" -> cell.setBackground(new Color(255, 100, 100)); // Rojo 
                    case "Pendiente" -> cell.setBackground(new Color(255, 255, 100)); // Amarillo 
                    default -> cell.setBackground(Color.WHITE); // Color por defecto
                }
            }else{
                switch (estado) {
                    case "Aprobado" -> cell.setBackground(new Color(0,255, 0)); // Verde 
                    case "Suspendido" -> cell.setBackground(new Color(255, 0, 0)); // Rojo 
                    case "Pendiente" -> cell.setBackground(new Color(255, 255, 0)); // Amarillo 
                    default -> cell.setBackground(Color.WHITE); // Color por defecto
                }
                cell.setForeground(Color.black);
            }
            return cell;
        }
    }

    // Método para configurar la tabla con el renderer
    public static void configurarTabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new EstadoTableCellRenderer());
    }
    
}

