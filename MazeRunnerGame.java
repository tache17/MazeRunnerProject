import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;



public class MazeRunnerGame implements MouseListener, ActionListener {
    private JFrame frame;
    private JPanel first;
    private JPanel second;
    private JPanel third;



    MazeRunnerGame(){
        // Initiate components
        JFrame frame = new JFrame("MazeRunner");
        frame.setLayout(new GridLayout(1, 5));

        //JPanel intro = new JPanel();
        JPanel first = new level(15,10,1);
        JPanel second = new level(15,10,2);
        JPanel third = new level(15,10,3);
        //JPanel end = new JPanel();

        //frame.add(intro);
        frame.add(first);
        frame.add(second);
        frame.add(third);
        //frame.add(end);







        // Design
        first.setBackground(Color.BLACK);
        second.setBackground(Color.BLACK);       
        third.setBackground(Color.BLACK);


        //frame.add(intro);
        frame.add(first);
        frame.add(second);
        frame.add(third);
        //frame.add(end);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        new MazeRunnerGame();

    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

}