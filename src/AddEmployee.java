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

public class AddEmployee extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;
    private JTextField name;
    private JTextField ssn;
    private JTextField wage;
    private JTextField hours;
    private JTextField position;
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    private JFormattedTextField dateOfHire;
    private JButton btnNewButton;
    private JButton backButton;

    public AddEmployee(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Add Employee");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 400, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("SSN");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblDateOfHire = new JLabel("Date\r\n of hire");
        lblDateOfHire.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDateOfHire.setBounds(58, 324, 124, 36);
        contentPane.add(lblDateOfHire);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 32));
        name.setBounds(214, 151, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        ssn = new JTextField();
        ssn.setFont(new Font("Tahoma", Font.PLAIN, 32));
        ssn.setBounds(214, 235, 228, 50);
        contentPane.add(ssn);
        ssn.setColumns(9);//changed ssn columns from 10 to 9

        dateOfHire = new JFormattedTextField(format);
        dateOfHire.setFont(new Font("Tahoma", Font.PLAIN, 32));
        dateOfHire.setBounds(214, 320, 228, 50);
        contentPane.add(dateOfHire);
        dateOfHire.setColumns(10);

        hours = new JTextField();
        hours.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hours.setBounds(707, 151, 228, 50);
        contentPane.add(hours);
        hours.setColumns(10);

        JLabel lblHours = new JLabel("Hours");
        lblHours.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHours.setBounds(542, 159, 99, 29);
        contentPane.add(lblHours);

        JLabel lblPosition = new JLabel("Position");
        lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPosition.setBounds(542, 245, 99, 24);
        contentPane.add(lblPosition);

        JLabel lblWage = new JLabel("Wage");
        lblWage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblWage.setBounds(542, 329, 139, 26);
        contentPane.add(lblWage);

        JLabel lblId = new JLabel("Employee ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblId.setBounds(542, 400, 179, 26);
        contentPane.add(lblId);

        id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
        id.setBounds(707, 400, 228, 50);
        contentPane.add(id);
        id.setColumns(10);

        wage = new JTextField();
        wage.setFont(new Font("Tahoma", Font.PLAIN, 32));
        wage.setBounds(707, 320, 228, 50);
        contentPane.add(wage);

        position = new JTextField();
        position.setFont(new Font("Tahoma", Font.PLAIN, 32));
        position.setBounds(707, 235, 228, 50);
        contentPane.add(position);

        btnNewButton = new JButton("Add");
        backButton = new JButton("Back");
        backButton.addActionListener(e->{
            if(e.getSource()==backButton){
                dispose();
                EmployeeOptions employeeOptions = new EmployeeOptions();
                employeeOptions.setVisible(true);
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id1 = id.getText();
                String name1 = name.getText();
                String ssn1 = ssn.getText();
                String dateOfHire1 = dateOfHire.getText();
                String hours1 = hours.getText();
                String wage1 = wage.getText();
                String position1 = position.getText();
                int len = ssn1.length();
                if(len!=9){
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid SSN");
                }


                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb", "root", "root");

                    String query = "INSERT INTO employee values('"+ id1 + "','" + name1 + "','" + ssn1 + "','" + dateOfHire1 + "','" +
                            hours1 + "','" + position1 + "','" + wage1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This employee already exists");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Employee " + name1 + " has been added");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(440, 447, 259, 74);
        contentPane.add(btnNewButton);

        backButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        backButton.setBounds(100, 447, 259, 74);
        contentPane.add(backButton);

    }
}
