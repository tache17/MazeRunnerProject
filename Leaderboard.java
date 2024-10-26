import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;



public class Leaderboard {

    public static class myGUI implements ActionListener, MouseListener {
        JFrame frame;
        JButton goBack;

        myGUI(){

            System.out.println("TEst");
            frame = new JFrame("Leaderboard");
            goBack = new JButton("Go back");
            goBack.setBackground(Color.WHITE);
            Leaderboard.read();
            frame.setLayout(new GridLayout(entries.size() + 2, 3));
            JPanel rank = new JPanel();
            rank.add(new JLabel("Rank:"));
            rank.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel name = new JPanel();
            name.add(new JLabel("Name:"));
            name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel time = new JPanel();
            time.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            time.add(new JLabel("Time (in Seconds):"));
            rank.setBackground(Color.GRAY);
            name.setBackground(Color.GRAY);
            time.setBackground(Color.GRAY);

            frame.add(rank);
            frame.add(name);
            frame.add(time);
            for(int i = 0; i != entries.size(); i++){
                JPanel first = new JPanel();
                first.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                JLabel firstLabel = new JLabel(Integer.toString(entries.get(i).pos));
                firstLabel.setForeground(Color.WHITE);
                first.setBackground(Color.GRAY);
                first.add(firstLabel, BorderLayout.CENTER);
                frame.add(first);
                JPanel second = new JPanel();
                second.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                JLabel secondLabel = new JLabel(entries.get(i).name);
                secondLabel.setForeground(Color.WHITE);
                second.setBackground(Color.GRAY);
                second.add(secondLabel, BorderLayout.CENTER);
                frame.add(second);
                JPanel third = new JPanel();
                third.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                JLabel thirdLabel = new JLabel(Integer.toString(entries.get(i).time));
                thirdLabel.setForeground(Color.WHITE);
                third.setBackground(Color.GRAY);
                third.add(thirdLabel, BorderLayout.CENTER);
                frame.add(third);
            }

            goBack.addActionListener(this);
            goBack.addMouseListener(this);
            JPanel left = new JPanel();
            left.setBackground(Color.GRAY);
            JPanel right = new JPanel();
            right.setBackground(Color.GRAY);
            left.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            right.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            frame.add(left);
            frame.add(goBack);
            frame.add(right);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1600, 1000);
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e){
            new MainMenu();
            frame.dispose();
        }
    
        public void mouseClicked(MouseEvent e){
    
        }
    
        public void mousePressed(MouseEvent e){
            
        }
    
        public void mouseReleased(MouseEvent e){
    
        }
    
        public void mouseEntered(MouseEvent e){
            goBack.setBackground(Color.YELLOW);
        }
    
        public void mouseExited(MouseEvent e){
            goBack.setBackground(Color.WHITE);
        }
    
    }

    public static class Entry {
        public final String name;
        public int pos;
        public int time;
    
        Entry(int pos, String name, int time) {
            this.name = name;
            this.pos = pos;
            this.time = time;
        }

        @Override
        public String toString() {
            return pos + " " + name + " " + time;
        }
    }

    private static ArrayList<Entry> entries = new ArrayList<>();


    public static void newEntry(String name, int time) {
        if(entries.isEmpty()){
            entries.add(new Entry(1, name, time));
        }
        for(int i = 0; i < entries.size(); i++) {
            if(entries.get(i).name.equals(name)) {
                if (entries.get(i).time <= time) {
                    return;
                }

                entries.remove(i);
                break;
            }
        }

        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).time > time){
                entries.add(i, new Entry(i + 1, name, time));
                break;
            }
        }

        for(int i = 0; i < entries.size(); i++){
            entries.get(i).pos = i + 1;
        }
    }

    private static File getFile() {
        // It's possible that the file location could cause issues as different VSCodes manage file locations differently.
        return new File("MazeRunnerProject/leaderboard.txt");
    }

    public static void read() {
        if(entries != null) {
            entries.clear();
        }
        try (Scanner rdr = new Scanner(getFile())) {
            rdr.nextLine();
            while(rdr.hasNext()) {
                Entry e = new Leaderboard.Entry(Integer.parseInt(rdr.next()), rdr.next(), Integer.parseInt(rdr.next()));
                entries.add(e);
            }
            rdr.close();
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    
    public static void write() {
        try (FileWriter wrt = new FileWriter(getFile())) {
            wrt.write("Rank Name Time\n");
            for (Entry entry : entries) {
                wrt.append(entry.toString());
                wrt.append("\n");
            }

            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}