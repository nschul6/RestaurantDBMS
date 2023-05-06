import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    AddFoodItem frame = new AddFoodItem();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        });
    }
}