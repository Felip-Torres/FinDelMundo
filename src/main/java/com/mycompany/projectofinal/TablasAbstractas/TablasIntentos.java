/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.TablasAbstractas;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import com.mycompany.projectofinal.dto.Intent;

/**
 * Clase que define el renderer para las celdas de la tabla de intentos,
 * cambiando el color de fondo de las celdas según el estado del intento.
 * @author Felip
 */
public class TablasIntentos extends AbstractTableModel{
    private List<Intent> listIntent;
    private String[] columnes = {"Id", "IdEjercicio", "Inici", "Estado"};

    public TablasIntentos(List<Intent> listIntent) {
        this.listIntent = listIntent;
    }
    
    /**
     * Devuelve el número de filas en la tabla.
     * 
     * @return el número de filas
     */
    @Override
    public int getRowCount() {
        return listIntent.size();
    }

    /**
     * Devuelve el número de columnas en la tabla.
     * 
     * @return el número de columnas
     */
    @Override
    public int getColumnCount() {
        return columnes.length;
    }

    /**
     * Devuelve el valor en la celda especificada por la fila y columna.
     * 
     * @param rowIndex el índice de la fila
     * @param columnIndex el índice de la columna
     * @return el valor en la celda especificada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return listIntent.get(rowIndex).getId();
            }
            case 1 -> {
                return listIntent.get(rowIndex).getIdEjercicio();
            }
            case 2 -> {
                return listIntent.get(rowIndex).getInici();
            }
            case 3 -> {
                return listIntent.get(rowIndex).getEstado();
            }
        }
        return null;
    }

    /**
     * Devuelve el nombre de la columna especificada.
     * 
     * @param column el índice de la columna
     * @return el nombre de la columna
     */
    @Override
    public String getColumnName(int column) {
        return columnes[column];
    }

    /**
     * Devuelve el índice de la columna con el nombre especificado.
     * 
     * @param column el nombre de la columna
     * @return el índice de la columna, o -1 si no se encuentra
     */
    public int getColumNum(String column) {
        for (int i = 0; i < columnes.length; i++) {
            if (columnes[i].equals(column)) return i;
        }
        return -1;
    }

    /**
     * Devuelve el intento en la fila especificada.
     * 
     * @param row el índice de la fila
     * @return el intento en la fila especificada
     */
    public Intent getIntent(int row) {
        return listIntent.get(row);
    }
    
    /**
     * Renderer para las celdas de la tabla que cambia el color de fondo según el estado del intento.
     */
    public static class EstadoTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener el modelo de datos y el valor del estado
            TablasIntentos model = (TablasIntentos) table.getModel();
            String estado = (String) model.getValueAt(row, model.getColumNum("Estado"));

            // Configurar el color de fondo según el estado
            if (!isSelected) {
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

    /**
     * Método para configurar la tabla con el renderer.
     * 
     * @param tabla la tabla a configurar
     */
    public static void configurarTabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new EstadoTableCellRenderer());
    }
    
}

