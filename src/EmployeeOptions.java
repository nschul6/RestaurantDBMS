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
public class EmployeeOptions extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton button = new JButton("View Employees");
    private JButton button2 = new JButton("Add Employees");
    private JButton button3 = new JButton("Delete Employees");
    private JButton button4 = new JButton("Back");

    public EmployeeOptions(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 500, 400);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);//?

        button.setBounds(140,100,200,40);
        button.setFocusable(false);
        button.addActionListener(e->{
            if(e.getSource()==button){//if the button is selected, create frame for view employees
                    dispose();
                    ViewEmployees frame = new ViewEmployees();
                    frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                    frame.pack();
                    frame.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button);

        button2.setBounds(140,140,200,40);
        button2.setFocusable(false);
        button2.addActionListener(e->{
            if(e.getSource()==button2){
                dispose();
                AddEmployee addEmployee = new AddEmployee();
                addEmployee.setVisible(true);
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button2);

        button3.setBounds(140,180,200,40);
        button3.setFocusable(false);
        button3.addActionListener(e->{
            if(e.getSource()==button3){

            }
        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button3);

        button4.setBounds(140,220,200,40);
        button4.setFocusable(false);
        button4.addActionListener(e->{
            if(e.getSource()==button4){
                dispose();
                LaunchPage launchPage = new LaunchPage();
                launchPage.setVisible(true);
            }
        });
        button4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button4);
    }


}
