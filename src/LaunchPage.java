import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LaunchPage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton button = new JButton("View Employees");
    private JButton button2 = new JButton("View Menu");
    private JButton button3 = new JButton("View Orders");
    private JButton button4 = new JButton("View Tables");
    public LaunchPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 500, 400);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        button.setBounds(140,100,200,40);
        button.setFocusable(false);
        button.addActionListener(e->{
            if(e.getSource()==button){
                dispose();
                EmployeeOptions employeeOptions = new EmployeeOptions();
                employeeOptions.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button);

        button2.setBounds(140,140,200,40);
        button2.setFocusable(false);
        button2.addActionListener(e->{
            if(e.getSource()==button2){
                dispose();
                MenuOptions menuOptions = new MenuOptions();
                menuOptions.setVisible(true);
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button2);

        button3.setBounds(140,180,200,40);
        button3.setFocusable(false);
        button3.addActionListener(e->{
            if(e.getSource()==button3){
                dispose();
                OrderOptions frame = new OrderOptions();
                frame.pack();
                frame.setVisible(true);
            }
        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button3);

        button4.setBounds(140,220,200,40);
        button4.setFocusable(false);
        button4.addActionListener(e->{
            if(e.getSource()==button4){
                dispose();
                AddTable addTable = new AddTable();
                addTable.setVisible(true);
            }
        });
        button4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button4);

    }
}
