import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
public class ViewEmployees extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton button = new JButton("Sum Wages");
    private JButton button2 = new JButton("Highest Paid Employee");
    private JButton button3 = new JButton("Longest Hire");
    private JButton button4 = new JButton("Back");

    public ViewEmployees() {

        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
        String url = "jdbc:mysql://localhost:3306/restaurantdb";
        String userid = "root";
        String password = "root";
        String sql = "SELECT * FROM employee";


        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program
        // is finished with them
        try (Connection connection = DriverManager.getConnection(url, userid, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            //  Get row data
            while (rs.next()) {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++)
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data
        //***need to put table inside a frame with other buttons for queries.
        setBounds(450, 190, 500, 400);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        button.setBounds(140,100,200,40);
        button.setFocusable(false);
        button.addActionListener(e->{
            if(e.getSource()==button){//if the button is selected, create frame for view employees
                dispose();
                EmployeeWage frame = new EmployeeWage();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button);
        button2.setBounds(140,180,200,40);
        button2.setFocusable(false);
        button2.addActionListener(e->{
            if(e.getSource()==button2){
                dispose();
                HighestPaidEmployee frame = new HighestPaidEmployee();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button2);

        button3.setBounds(140,220,200,40);
        button3.setFocusable(false);
        button3.addActionListener(e->{
            if(e.getSource()==button3){
                //add jtable for query display

            }
        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button3);

        button4.setBounds(120,100,200,40);
        button4.setFocusable(false);
        button4.addActionListener(e->{
            if(e.getSource()==button4){
                dispose();
                EmployeeOptions frame = new EmployeeOptions();
                frame.setVisible(true);
                //back
            }
        });
        button4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button4);
        //^the frame
        // v the table

        JTable table = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }
}
