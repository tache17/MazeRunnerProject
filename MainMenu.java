import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener, MouseListener{
    private JFrame frame;
    private JButton startButton;
    private JLabel label;
    GridBagConstraints gbc = new GridBagConstraints();


    MainMenu(){
        // Frame, Panel, Button and Label SET UP
        ImageIcon icon = new ImageIcon("MazeRunnerProject/MazeRunnerLogo.png");
        frame = new JFrame("Main Menu");
        label = new JLabel(icon);
        frame.add(this);
        startButton = new JButton("Start!");

        // Designing
        setBackground(Color.GRAY);
        setLayout(new GridBagLayout());
        startButton.addActionListener(this);
        startButton.addMouseListener(this);
        startButton.setFocusable(false);
        startButton.setPreferredSize(new Dimension(100, 100));
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(startButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(label, gbc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        new Leaderboard.myGUI();
        frame.dispose();
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){
        startButton.setBackground(Color.YELLOW);
    }

    public void mouseExited(MouseEvent e){
        startButton.setBackground(Color.WHITE);
    }

    public static void main(String[] args){
        new MainMenu();
    }
}
