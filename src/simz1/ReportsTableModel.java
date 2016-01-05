package simz1;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ReportsTableModel extends DefaultTableModel {
    public ReportsTableModel() {
      super(new String[]{"Product Name", "Received Quantity", "Remained Quantity"}, 0);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = String.class;
          break;
      }
      return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return false;
    }

    
}
