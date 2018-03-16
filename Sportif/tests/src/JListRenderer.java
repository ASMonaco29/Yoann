package src;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/* ************************************* CLASSE POUR JLIST  ******************** */

@SuppressWarnings("serial")
class JListRenderer extends JScrollPane implements TableCellRenderer {
  @SuppressWarnings("rawtypes")
  JList list;
  
  @SuppressWarnings("rawtypes")
  public JListRenderer() {
    list = new JList();
    getViewport().add(list);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellRendererComponent(JTable table, Object value,
                                  boolean isSelected, boolean hasFocus,
                                  int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
      list.setForeground(table.getSelectionForeground());
      list.setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
      list.setForeground(table.getForeground());
      list.setBackground(table.getBackground());
    }
  
    list.setModel((DefaultListModel) value);
 
    return this;
  }
}