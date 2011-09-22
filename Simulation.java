import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

class Simulation extends JFrame {

    private SimComponent canvas;
    private World world;

    // Set parameters for simulation
    final static Integer gridWidth  = 250;
    final static Integer gridHeight = 120;
    final static Integer tileSize   =   4;

    final static Integer canvasWidth  = gridWidth * tileSize;
    final static Integer canvasHeight = gridHeight * tileSize;

    // Control speed of simulation
    final static Integer delay = 500;

    Simulation() {
        super("Virtual Ant Simulation");
        canvas = new SimComponent(canvasWidth, canvasHeight);
        (this.getContentPane()).add(canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void runSimulation() {
        setBackground();
        world = new World(gridWidth, gridHeight);
        // Loop forever
        while (true) {
            canvas.clearOffscreen();
            world.draw(canvas);
            canvas.drawOffscreen();
            world.step();
//             // Control speed of simulation
//             // Comment this out for maximum speed
//            try { Thread.sleep(delay); }
//            catch(InterruptedException e) {}
        }
    }

    void setBackground() {
        Graphics2D g = canvas.getBackgroundGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.pack();
        sim.setVisible(true);
        sim.runSimulation();
    }
}
