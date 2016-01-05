
package simz1;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class addOrdersTableModel extends DefaultTableModel {
    public addOrdersTableModel() {
      super(new String[]{"","Product ID", "Product Name","Received Quantity"}, 0);
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
        return column == 0 || column==3;
        
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if(column == 1){
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(1, aValue);
        fireTableCellUpdated(row, column);
      }
    }
}
