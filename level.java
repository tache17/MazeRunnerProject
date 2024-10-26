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
    private int slot;
    private Color base = Color.YELLOW; 
    private Color hover = Color.RED;   

    // constructor to make and display grid
    public level(int rows, int cols, int slot) {
        this.rows = rows;
        this.cols = cols;
        this.slot = slot;
    

        setLayout(new GridLayout(rows, cols));

        
        genBlocks();
    }

    //read text file for level designs
    private static String[] textReader(){
        try {
            //import file and split into array for diff levels
            // It's possible that the file location could cause issues as different VSCodes manage file locations differently.

            File file = new File("levels.txt");
            Scanner scanner = new Scanner(file);
            String text = "";
            String[] textSplit = null;
            
            
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                text += line;
            }

            scanner.close();
            textSplit = text.split("next");
            return textSplit;

        } catch (FileNotFoundException e) {

            System.out.println("File not fund :" + e.getMessage());
            return null;

        }
        
    } 

    // generate blocks for the frame
    private void genBlocks() {

        //import text file and use the one which corresponds to its slot (can change to varied levels later by introducing random slots)
        String[] textFull = textReader();
        String text = textFull[slot-1];
        System.out.println(textFull);
        
        //generate each block thru loop
        for (int i = 0; i < rows * cols; i++) {
            // make JPanel for each block
            JPanel block = new JPanel();
            int index = i;
            block.setBackground(base);

            //label for testing
            //JLabel label = new JLabel(Character.toString(text.charAt(index))); 
            //label.setForeground(Color.WHITE);
            //block.add(label, BorderLayout.CENTER);

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
