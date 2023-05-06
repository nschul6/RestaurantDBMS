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
public class AddFoodItem extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField name;
    private JTextField category;
    private JTextField price;
    private JTextField season;
    private JTextField supplierId;
    private JButton btnNewButton;

    public AddFoodItem() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Add Food Item");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Category");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblDateOfHire = new JLabel("Price");
        lblDateOfHire.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDateOfHire.setBounds(58, 324, 124, 36);
        contentPane.add(lblDateOfHire);

        JLabel lblHours = new JLabel("Season");
        lblHours.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHours.setBounds(542, 159, 99, 29);
        contentPane.add(lblHours);

        JLabel lblPosition = new JLabel("Supplier ID");
        lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPosition.setBounds(542, 245, 99, 24);
        contentPane.add(lblPosition);

        JLabel lblId = new JLabel("Item ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblId.setBounds(542, 329, 139, 26);
        contentPane.add(lblId);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 32));
        name.setBounds(214, 151, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        category = new JTextField();
        category.setFont(new Font("Tahoma", Font.PLAIN, 32));
        category.setBounds(214, 235, 228, 50);
        contentPane.add(category);
        category.setColumns(10);

        price = new JTextField();
        price.setFont(new Font("Tahoma", Font.PLAIN, 32));
        price.setBounds(214, 320, 228, 50);
        contentPane.add(price);
        price.setColumns(10);

        season = new JTextField();
        season.setFont(new Font("Tahoma", Font.PLAIN, 32));
        season.setBounds(707, 151, 228, 50);
        contentPane.add(season);
        season.setColumns(10);

        supplierId = new JTextField();
        supplierId.setFont(new Font("Tahoma", Font.PLAIN, 32));
        supplierId.setBounds(707, 235, 228, 50);
        contentPane.add(supplierId);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(707, 320, 228, 50);
        contentPane.add(id);
        id.setColumns(10);

        btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id1 = id.getText();
                String name1 = name.getText();
                String category1 = category.getText();
                String price1 = price.getText();
                String season1 = season.getText();
                String supplierId1 = supplierId.getText();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb", "root", "root");

                    String query = "INSERT INTO food_item values('"+ id1 + "','" + name1 + "','" + category1 + "','" + price1 + "','" +
                            season1 + "','" + supplierId1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This employee already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Employee " + name1 + "has been added");
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
    }
}
