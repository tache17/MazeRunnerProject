import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomBlocksHoverSwing extends JPanel implements MouseMotionListener {
    private ArrayList<Rectangle> blocks;
    private ArrayList<Color> blockColors;
    private final int NUM_BLOCKS = 10;
    private Random random;

    public RandomBlocksHoverSwing() {
        this.blocks = new ArrayList<>();
        this.blockColors = new ArrayList<>();
        this.random = new Random();
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);

        // Generate random blocks
        for (int i = 0; i < NUM_BLOCKS; i++) {
            int width = random.nextInt(50) + 50;
            int height = random.nextInt(50) + 50;
            int x = random.nextInt(700);
            int y = random.nextInt(500);
            blocks.add(new Rectangle(x, y, width, height));
            blockColors.add(Color.BLUE);  // Initially all blocks are blue
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw all blocks
        for (int i = 0; i < blocks.size(); i++) {
            g2d.setColor(blockColors.get(i));
            g2d.fill(blocks.get(i));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        // Check if the mouse is hovering over any block
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).contains(x, y)) {
                blockColors.set(i, Color.RED);  // Change block color to red if hovered
            } else {
                blockColors.set(i, Color.BLUE);  // Revert block color to blue if not hovered
            }
        }
        repaint();  // Repaint the panel to reflect the color changes
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // We don't need to handle dragging for this case
    }

    public static void main(String[] args) {
        // Create a JFrame to hold the JPanel
        JFrame frame = new JFrame("Random Blocks Hover - Swing Example");
        RandomBlocksHoverSwing randomBlocksPanel = new RandomBlocksHoverSwing();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(randomBlocksPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}
