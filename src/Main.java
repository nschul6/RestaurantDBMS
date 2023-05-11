import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    //CreateRestaurant frame = new CreateRestaurant();
                    LaunchPage frame = new LaunchPage();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        });
    }
}// we can use the style from ViewEmployees to add a back button to all queries so program we dont lose the window early.