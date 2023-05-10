import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    AddTable frame = new AddTable();
                    //AddEmployee frame = new AddEmployee();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        });
    }
}