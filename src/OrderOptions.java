import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class OrderOptions extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton button = new JButton("View Orders");
    private JButton button2 = new JButton("Add Order");
    private JButton button3 = new JButton("Complete Order");
    private JButton button4 = new JButton("Back");
    public OrderOptions(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 500, 400);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setLayout(null);

        button.setBounds(140,100,200,40);
        button.setFocusable(false);
        button.addActionListener(e->{
            if(e.getSource()==button){//if the button is selected, create frame for view employees
                dispose();
                ViewOrders frame = new ViewOrders();
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
                //add order
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button2);

        button3.setBounds(140,180,200,40);
        button3.setFocusable(false);
        button3.addActionListener(e->{
            if(e.getSource()==button3){
                //complete order
            }
        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button3);

        button4.setBounds(140,220,200,40);
        button4.setFocusable(false);
        button4.addActionListener(e->{
            if(e.getSource()==button4){
                dispose();
                LaunchPage frame = new LaunchPage();
                frame.setVisible(true);
                //back
            }
        });
        button4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPane.add(button4);

    }
}