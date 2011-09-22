import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

class Test extends JFrame {

    private SimComponent canvas;
    private World world;

    final static Integer gridWidth  = 250;
    final static Integer gridHeight = 150;
    final static Integer tileSize   =   4;

    final static Integer canvasWidth  = gridWidth * tileSize;
    final static Integer canvasHeight = gridHeight * tileSize;

    final Integer numSteps = 20000;

    Test() {
        super("Virtual Ant Test");
        canvas = new SimComponent(canvasWidth, canvasHeight);
        (this.getContentPane()).add(canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void runTest() {
        setBackground();
        world = new World(gridWidth, gridHeight);

        // Take lots of steps
        for (Integer step = 1; step <= numSteps; step++) {
            world.step();
        }
        // Draw result
        canvas.clearOffscreen();
        world.draw(canvas);
        canvas.drawOffscreen();
    }

    void setBackground() {
        Graphics2D g = canvas.getBackgroundGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public static void main(String[] args) {
        Test sim = new Test();
        sim.pack();
        sim.setVisible(true);
        sim.runTest();
    }
}
