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
public class CreateRestaurant extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField name;
    private JTextField address;
    private JTextField phone;
    private JTextField manager_ssn;
    private JButton btnNewButton;

    public CreateRestaurant(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Create Restaurant");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Restaurant Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Address");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblDateOfHire = new JLabel("Phone");
        lblDateOfHire.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDateOfHire.setBounds(58, 324, 124, 36);
        contentPane.add(lblDateOfHire);

        JLabel lblHours = new JLabel("Manager SSN");
        lblHours.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHours.setBounds(542, 159, 99, 29);
        contentPane.add(lblHours);

        JLabel lblPosition = new JLabel("Restaurant ID");
        lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPosition.setBounds(542, 245, 99, 24);
        contentPane.add(lblPosition);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 32));
        name.setBounds(214, 151, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        address = new JTextField();
        address.setFont(new Font("Tahoma", Font.PLAIN, 32));
        address.setBounds(214, 235, 228, 50);
        contentPane.add(address);
        address.setColumns(10);

        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 32));
        phone.setBounds(214, 320, 228, 50);
        contentPane.add(phone);
        phone.setColumns(10);

        manager_ssn = new JTextField();
        manager_ssn.setFont(new Font("Tahoma", Font.PLAIN, 32));
        manager_ssn.setBounds(707, 151, 228, 50);
        contentPane.add(manager_ssn);
        manager_ssn.setColumns(10);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(707, 235, 228, 50);
        contentPane.add(id);
        id.setColumns(10);

        btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id1 = id.getText();
                String name1 = name.getText();
                String address1 = address.getText();
                String phone1 = phone.getText();
                String manager_ssn1 = manager_ssn.getText();
                int len = phone1.length();
                if(len!=10){
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid phone number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb", "root", "root");

                    String query = "INSERT INTO restaurant values('"+ id1 + "','" + name1 + "','" + address1 + "','" + phone1 + "','" +
                            manager_ssn1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This employee already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Restaurant " + name1 + " has been added");
                    }
                    connection.close();
                    dispose();
                    LaunchPage launchPage = new LaunchPage();
                    launchPage.setVisible(true);
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
