package self;

import javax.swing.DefaultCellEditor;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.table.AbstractTableModel;  
import javax.swing.table.TableModel;  
public class EditableTable  
{  
    public static void main(String[] a)  
    {  
        JFrame frame = new JFrame();  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        String[] columnTitles = { "First Name", "Last Name", "weight", "Qualification", "age(18+)" };  
        @SuppressWarnings("deprecation")
		Object[][] dataEntries = {  
        { "ABHISHEK", "DUBEY", new Integer(50), "B-tech", new Boolean(true) },  
        { "MANISH", "TIWARI", new Integer(80), "PG", new Boolean(true) },  
        { "ANURUDDHA ", "PANDEY", new Integer(80), "Msc", new Boolean(true) },  
        { "Bindresh", "AGINHOTRI", new Integer(80), "Bsc", new Boolean(true) },  
        { "SOURABH", "TRIPATHI", new Integer(80), "PG", new Boolean(true) },  
        { "AMIT", "GUPTA", new Integer(70), "Gratuate", new Boolean(true) },  
        { "AMIT", "VERMA", new Integer(55), "12TH", new Boolean(true) }, };  
        TableModel model = new EditableTableModel(columnTitles, dataEntries);  
        JTable table = new JTable(model);  
        table.createDefaultColumnsFromModel();  
        String[] Education = { "PG","Msc", "B-Tech,","Bsc", "12th", "10th" };  
        @SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(Education);  
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));  
		frame.add(new JScrollPane(table));  
        frame.setSize(300, 200);  
        frame.setVisible(true);  
        }  
    }  
     @SuppressWarnings("serial")
	class EditableTableModel extends AbstractTableModel  
    {  
        String[] columnTitles;  
        Object[][] dataEntries;  
        int rowCount;  
        public EditableTableModel(String[] columnTitles, Object[][] dataEntries)  
        {  
            this.columnTitles = columnTitles;  
            this.dataEntries = dataEntries;  
        }  
        public int getRowCount()  
        {  
            return dataEntries.length;  
        }  
        public int getColumnCount()  
        {  
            return columnTitles.length;  
        }  
        public Object getValueAt(int row, int column)  
        {  
            return dataEntries[row][column];  
        }  
        public String getColumnName(int column)  
        {  
            return columnTitles[column];  
        }  
        @SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column)  
        {  
            return getValueAt(0, column).getClass();  
        }  
        public boolean isCellEditable(int row, int column)  
        {  
            return true;  
        }  
        public void setValueAt(Object value, int row, int column)  
        {  
             dataEntries[row][column] = value;  
        }  
    }  