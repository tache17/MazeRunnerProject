import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class MainMenu extends JPanel implements ActionListener, MouseListener{
    // Initializing variables
    private JFrame frame;
    private JButton startButton;
    private JLabel label;
    private JButton leaderButton;
    GridBagConstraints gbc = new GridBagConstraints();


    MainMenu(){
        // Setting up an icon image for the main menu, plus setting up teh frame, label and the start/leaderboard button.
        // It's possible that the file location could cause issues as different VSCodes manage file locations differently.
        ImageIcon icon = new ImageIcon("MazeRunnerProject/MazeRunnerLogo.png");
        frame = new JFrame("Main Menu");
        label = new JLabel(icon);
        frame.add(this);
        startButton = new JButton("Start");
        leaderButton = new JButton("Leaderboard");

        // Designing layout, using gridbagconstraints for layout.
        setBackground(Color.GRAY);
        setLayout(new GridBagLayout());
        startButton.addActionListener(this);
        startButton.addMouseListener(this);
        startButton.setFocusable(false);
        startButton.setPreferredSize(new Dimension(200, 200));
        leaderButton.addActionListener(this);
        leaderButton.addMouseListener(this);
        leaderButton.setFocusable(false);
        leaderButton.setPreferredSize(new Dimension(200, 200));
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(startButton, gbc);
        gbc.gridx = 4;
        this.add(leaderButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(label, gbc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);
        frame.setVisible(true);

    }
    


    public void actionPerformed(ActionEvent e){
        // Checking which button was clicked to go to Leaderboard or Start the game.
        if(e.getSource().equals(startButton)){
            new MazeRunnerGame();
            frame.dispose();
        } else if(e.getSource().equals(leaderButton)){
            new Leaderboard.myGUI();
            frame.dispose();
        }
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){
        
        if(e.getSource().equals(startButton)){
            startButton.setBackground(Color.YELLOW);
        } else if(e.getSource().equals(leaderButton)){
            leaderButton.setBackground(Color.YELLOW);
        }

    }

    public void mouseExited(MouseEvent e){
        if(e.getSource().equals(startButton)){
            startButton.setBackground(Color.WHITE);
        } else if(e.getSource().equals(leaderButton)){
            leaderButton.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args){
        new MainMenu();
    }
}
