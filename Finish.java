import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Finish extends JPanel implements ActionListener, MouseListener {
    private JFrame frame;
    private JButton menuButton;
    private JTextField nickname;
    private JLabel congrats;
    private int time;


    Finish(int t){
        String test = "abcdef1";
        String test2 = "abcdefg";

        // Initiating variables
        time = t;
        frame = new JFrame();
        frame.add(this);
        menuButton = new JButton("Main Menu");
        congrats = new JLabel("Congratulations, you finished in " + t + " seconds! To submit your score to the local leaderboard, " +
         "enter your name under, or just go back to the Main Menu!");
        nickname = new JTextField("Nickname (Click enter to submit, limit of 10 characters and only letters)");

        // Designing
        setBackground(Color.GRAY);
        menuButton.addActionListener(this);
        menuButton.addMouseListener(this);
        menuButton.setFocusable(false);
        menuButton.setPreferredSize(new Dimension(100, 100));
        nickname.addActionListener(this);
        this.add(congrats);
        this.add(menuButton);
        this.add(nickname);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);
        frame.setVisible(true);
    
        

    }

    public boolean onlyLetters(String str){
        if(str == null || str == ""){
            return false;
        }
        for(int i = 0; i != str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                return false;
            }
        }


        return true;
    }

    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == menuButton){
            new MainMenu();
            frame.dispose();
        }
        else{
            String name = e.getActionCommand();
            
            if(name.length() > 10 || !onlyLetters(name) ){
                nickname.setText("Limit of 10 characters and only letters are allowed!");
            }
            else{
                Leaderboard.add(name, time);
                remove(nickname);
            }
        }


    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){
        menuButton.setBackground(Color.YELLOW);
    }

    public void mouseExited(MouseEvent e){
        menuButton.setBackground(Color.WHITE);
    }

}
