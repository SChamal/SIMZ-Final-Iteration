package simz1;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHAM PC
 */
public class tableModelSalesperson extends DefaultTableModel {

    public tableModelSalesperson() {
      super(new String[]{ "Product Code", "Product Name", "Price", "Expiry Date", "Quantity", "If Expired"}, 0);
    }

   // @Override
   /* public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      
      return clazz;
    }*/

    @Override
    public boolean isCellEditable(int row, int column) {
      return false;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (column == 1){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(1, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 2){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(2, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 3){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(3, aValue);
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
    }
    

  }