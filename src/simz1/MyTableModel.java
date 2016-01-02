/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simz1;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHAM PC
 */
public class MyTableModel extends DefaultTableModel {
    
    public MyTableModel() {
      super(new String[]{" ", "Product Code", "Product Name", "Price", "Expiry Date", "Available Stock", "Received Stock", "If Expired"}, 0);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = Boolean.class;
          break;
      }
      return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return column == 0 || column == 4 || column ==6;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (aValue instanceof Boolean && column == 0) {
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(0, (boolean)aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 4){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(4, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 5){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(5, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 6){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(6, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 7){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(7, aValue);
        fireTableCellUpdated(row, column);
      }
    }
    

  }
