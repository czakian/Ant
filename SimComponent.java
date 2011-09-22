import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

class SimComponent extends JComponent {

    Integer xdim, ydim;

    private BufferedImage background;
    private BufferedImage offscreen;

    SimComponent(Integer canvasWidth, Integer canvasHeight) {
        xdim = canvasWidth;
        ydim = canvasHeight;
        this.setSize(xdim, ydim);
        this.setPreferredSize(new Dimension(xdim, ydim));
        background = new BufferedImage(xdim, ydim, BufferedImage.TYPE_INT_RGB);
        offscreen = new BufferedImage(xdim, ydim, BufferedImage.TYPE_INT_RGB);
    }

    public void clearOffscreen() {
        Graphics2D g = offscreen.createGraphics();
        g.drawImage(background, 0, 0, null);
    }

    public Graphics2D getBackgroundGraphics() {
        return background.createGraphics();
    }

    public Graphics2D getOffscreenGraphics() {
        return offscreen.createGraphics();
    }

    public void drawOffscreen() {
        Graphics g;
        g = this.getGraphics();
        g.drawImage(offscreen, 0, 0, null);
    }


}
