import javax.swing.*;

public class LaunchPage {
    JFrame frame = new JFrame();
    JButton button = new JButton("New Window");
    LaunchPage(){
        button.setBounds(100,160,200,40);
        button.setFocusable(false);
        button.addActionListener(e->{
            if(e.getSource()==button){

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(button);
    }
}
