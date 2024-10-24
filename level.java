import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class level extends JPanel {

    // create variables and colours for ease of use
    private int rows;
    private int cols;  
    private Color base = Color.YELLOW; 
    private Color hover = Color.RED;   

    // constructor to make and display grid
    public level(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    

        setLayout(new GridLayout(rows, cols));

        
        genBlocks();
    }

    //read text file for level designs
    private static String textReader(){
        try {
            File file = new File("levels.txt");
            Scanner scanner = new Scanner(file);
            String text = "";
            
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                text += line;
            }
            scanner.close();
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("File not fund :" + e.getMessage());
            return null;
        }
        
    } 

    // generate blocks for the frame
    private void genBlocks() {
        String text = textReader();

        for (int i = 0; i < rows * cols; i++) {
            // make JPanel for each block
            JPanel block = new JPanel();
            int index = i;
            block.setBackground(base);

            JLabel label = new JLabel(Character.toString(text.charAt(index))); //label for testing
            label.setForeground(Color.WHITE);
            block.add(label, BorderLayout.CENTER);

            // adds mouse hover effect 
            block.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(Character.toString(text.charAt(index)).equals("x")) {
                        block.setBackground(Color.BLACK);
                    }
                    else {
                        block.setBackground(hover);
                    }
                      
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    block.setBackground(base);  // Revert to original color
                }
            });

            // Add the block (JPanel) to the GridLayout
            add(block);
        }
    }

    // Getter for rows
    public int getRows() {
        return rows;
    }

    // Getter for columns
    public int getCols() {
        return cols;
    }

    // Setters for default and hover colors if customization is needed
    public void setDefaultColor(Color defaultColor) {
        this.base = defaultColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hover = hoverColor;
    }
}
