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
        frame.setLayout(new GridLayout(1, 3));
        JPanel first = new JPanel();
        JPanel second = new JPanel();
        JPanel third = new JPanel();

        frame.add(first);
        frame.add(second);
        frame.add(third);







        // Design
        first.setBackground(Color.RED);
        second.setBackground(Color.GREEN);       
        third.setBackground(Color.BLUE);


        frame.add(first);

        frame.add(second);
        frame.add(third);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);
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