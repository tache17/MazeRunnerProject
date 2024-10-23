import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class level extends JPanel implements MouseMotionListener {
    private ArrayList<int[]> blocks;  // Store [x, y, width, height] for each block
    private ArrayList<Color> blockColors;
    private int numBlocks;  // Number of blocks to generate
    private Random random;

    // Constructor that allows setting the number of blocks
    public level(int numBlocks) {
        this.numBlocks = numBlocks;
        this.blocks = new ArrayList<>();
        this.blockColors = new ArrayList<>();
        this.random = new Random();
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);

        // Generate random blocks
        generateBlocks();
    }

    // Method to generate random blocks
    private void generateBlocks() {
        for (int i = 0; i < numBlocks; i++) {
            int width = random.nextInt(50) + 50;
            int height = random.nextInt(50) + 50;
            int x = random.nextInt(700);
            int y = random.nextInt(500);
            blocks.add(new int[]{x, y, width, height});  // Store block as an int[] array
            blockColors.add(Color.BLUE);  // Initially all blocks are blue
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all blocks
        for (int i = 0; i < blocks.size(); i++) {
            int[] block = blocks.get(i);
            g.setColor(blockColors.get(i));
            g.fillRect(block[0], block[1], block[2], block[3]);  // Use fillRect for custom rectangle
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Check if the mouse is hovering over any block
        for (int i = 0; i < blocks.size(); i++) {
            int[] block = blocks.get(i);
            if (isMouseOverBlock(mouseX, mouseY, block)) {
                blockColors.set(i, Color.RED);  // Change block color to red if hovered
            } else {
                blockColors.set(i, Color.BLUE);  // Revert block color to blue if not hovered
            }
        }
        repaint();  // Repaint the panel to reflect the color changes
    }

    // Helper method to check if the mouse is over a block
    private boolean isMouseOverBlock(int mouseX, int mouseY, int[] block) {
        return mouseX >= block[0] && mouseX <= (block[0] + block[2])
            && mouseY >= block[1] && mouseY <= (block[1] + block[3]);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // We don't need to handle dragging for this case
    }
}
