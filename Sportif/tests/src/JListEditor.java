package src;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* ************************************* CLASSE POUR JLIST  ******************** */

@SuppressWarnings("serial")
class JListEditor extends DefaultCellEditor {
  protected JScrollPane scrollpane;
  @SuppressWarnings("rawtypes")
  protected JList list;
  @SuppressWarnings("rawtypes")
  protected DefaultListModel mlm;
  
  @SuppressWarnings("rawtypes")
  public JListEditor() {
    super(new JCheckBox());
    scrollpane = new JScrollPane();
    list = new JList(); 
    scrollpane.getViewport().add(list);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Component getTableCellEditorComponent(JTable table, Object value,
                                   boolean isSelected, int row, int column) {
    list.setModel((DefaultListModel) value);
   
    mlm = (DefaultListModel) value;
   
    return scrollpane;
  }
  
}

