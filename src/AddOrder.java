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
public class AddOrder extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField tableId;
    private JTextField itemId;
    private JButton btnNewButton;
    private JButton backButton;

    public AddOrder() {

        //open frames for reference
        //ViewEmployees viewEmployees = new ViewEmployees();
        //viewEmployees.setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Create Order");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 400, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblId = new JLabel("Order ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblId.setBounds(58, 152, 99, 43);
        contentPane.add(lblId);

        JLabel lblNewLabel = new JLabel("Table ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblItemId = new JLabel("Item ID");
        lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblItemId.setBounds(58, 324, 124, 36);
        contentPane.add(lblItemId);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(214, 151, 228, 50);
        contentPane.add(id);
        id.setColumns(10);

        tableId = new JTextField();
        tableId.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tableId.setBounds(214, 235, 228, 50);
        contentPane.add(tableId);
        tableId.setColumns(10);

        itemId = new JTextField();
        itemId.setFont(new Font("Tahoma", Font.PLAIN, 32));
        itemId.setBounds(214, 320, 228, 50);
        contentPane.add(itemId);
        itemId.setColumns(10);

        btnNewButton = new JButton("Add");
        backButton = new JButton("Back");
        backButton.addActionListener(e->{
            if(e.getSource()==backButton){
                dispose();
                OrderOptions orderOptions = new OrderOptions();
                orderOptions.setVisible(true);
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id1 = id.getText();
                String tableId1 = tableId.getText();
                String itemId1 = itemId.getText();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb", "root", "root");

                    String query = "INSERT INTO order_ values('"+ id1 + "','" + tableId1 + "','" + itemId1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This item already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Order " + id1 + " has been added");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);

        backButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        backButton.setBounds(100, 447, 259, 74);
        contentPane.add(backButton);

    }
}
