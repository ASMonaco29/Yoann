package src;

import java.awt.*; 
import javax.swing.*; 
import javax.swing.table.*; 

/* 
 * TableWithCheckbox.java 
 */ 

@SuppressWarnings("serial")
public class TableWithCheckbox extends JFrame { 
    private JTable table; 
    public TableWithCheckbox() { 
        super("TableWithCheckbox"); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        setSize(400, 300); 
        setLocationRelativeTo(null); 
        table = new JTable(); 
        table.setModel(new DefaultTableModel( 
            new Object [][] { 
                {"1", new Boolean(true)}, 
                {"2", new Boolean(false)}, 
                {"3", new Boolean(true)}, 
                {"4", new Boolean(true)} 
            }, 
            new String [] { 
                "Title 1", "Title 2" 
            } 
        ) 
        
        { 
            @SuppressWarnings("rawtypes")
            Class[] types = new Class [] { 
                String.class, Boolean.class 
            }; 

            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Class getColumnClass(int columnIndex) { 
                return types [columnIndex]; 
            } 
        }); 
        
        
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER); 
    } 
    public static void main(final String args[]) { 
        EventQueue.invokeLater(new Runnable() { 
            public void run() { 
                new TableWithCheckbox().setVisible(true); 
            } 
        }); 
    } 
}