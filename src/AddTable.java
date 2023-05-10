import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddTable extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField size;
    private JTextField waiter_id;
    private JTextField num_people;
    private JButton btnNewButton;

    public AddTable(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Add a table");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 400, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblID = new JLabel("ID");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblID.setBounds(58, 152, 99, 43);
        contentPane.add(lblID);

        JLabel lblSize = new JLabel("Size");
        lblSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSize.setBounds(58, 243, 110, 29);
        contentPane.add(lblSize);

        JLabel lblWaiter_ID = new JLabel("Waiter ID");
        lblWaiter_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblWaiter_ID.setBounds(58, 324, 124, 36);
        contentPane.add(lblWaiter_ID);

        JLabel lblNum_People = new JLabel("Number of people sat ");
        lblNum_People.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNum_People.setBounds(500, 151, 228, 50);
        contentPane.add(lblNum_People);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(214, 151, 228, 50);
        contentPane.add(id);
        id.setColumns(3);//changed ssn columns from 10 to 9

        size = new JTextField();
        size.setFont(new Font("Tahoma", Font.PLAIN, 32));
        size.setBounds(214, 235, 228, 50);
        contentPane.add(size);
        size.setColumns(2);

        waiter_id = new JTextField();
        waiter_id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        waiter_id.setBounds(214, 320, 228, 50);
        contentPane.add(waiter_id);
        waiter_id.setColumns(10);

        num_people = new JTextField();
        num_people.setFont(new Font("Tahoma", Font.PLAIN, 32));
        num_people.setBounds(707, 151, 228, 50);
        contentPane.add(num_people);
        num_people.setColumns(2);

        btnNewButton = new JButton("Add");

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //id size waiter_id num_people
                String id1 = id.getText();
                String size1 = size.getText();
                String waiter_id1 = waiter_id.getText();
                String num_people1 = num_people.getText();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb", "root", "root");

                String query = "INSERT INTO table_ values('"+ id1 + "','" + size1 + "','" + waiter_id1 + "','" + num_people1 + "')";

                Statement sta = connection.createStatement();
                int x = sta.executeUpdate(query);
                if (x == 0) {
                    JOptionPane.showMessageDialog(btnNewButton, "This table is already occupied.");
                } else {
                    JOptionPane.showMessageDialog(btnNewButton,
                            "Table " + id1 + " has been sat.");
                }
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        });
    }
}
