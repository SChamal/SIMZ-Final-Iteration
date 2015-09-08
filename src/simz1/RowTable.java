/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simz1;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class RowTable extends JTable
{
     Map<Integer, Color> rowColor = new HashMap<Integer, Color>();

     public RowTable(TableModel model)
     {
          super(model);
     }

     @Override
     public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
     {
          Component c = super.prepareRenderer(renderer, row, column);

          if (!isRowSelected(row))
          {
               Color color = rowColor.get( row );
               c.setBackground(color == null ? getBackground() : color);
          }

          return c;
     }

     public void setRowColor(int row, Color color)
     {
          rowColor.put(row, color);
     }
}
