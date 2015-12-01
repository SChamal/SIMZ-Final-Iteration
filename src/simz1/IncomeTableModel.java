
package simz1;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class IncomeTableModel extends DefaultTableModel {
    public IncomeTableModel() {
      super(new String[]{"Description", "Credit(Rs.)", "Debit(Rs.)"}, 0);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
            clazz = String.class;
            break;
        /*case 1:
            clazz= Float.class;
            break;
        case 2:
            clazz= Float.class;
            break;*/
      }
      return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return false;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if(column == 0){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(0, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 1){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(1, aValue);
        fireTableCellUpdated(row, column);
      }
      if(column == 2){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(2, aValue);
        fireTableCellUpdated(row, column);
      }
    }
}
