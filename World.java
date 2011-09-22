import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

class World {

    // The world consists of a grid of certain dimensions,
    // and a single ant.
    Grid grid;
    Ant ant;
    Integer gridWidth, gridHeight;

    // World constructor
    World(Integer width, Integer height) {
        grid = new Grid(width, height);
        ant = new Ant(width/2, height/2, Ant.Direction.Y);
        gridWidth = width;
        gridHeight = height;
    }

    // Advance the world to the next step in the simulation.
    void step() {
        // Your code here.
				State state = grid.state(ant.x, ant.y);
				grid.update(ant.x, ant.y);
				ant.advance(state, gridWidth, gridHeight);
    }

    // Render the current world state to the display canvas.
    void draw(SimComponent canvas) {
        Graphics2D g = canvas.getOffscreenGraphics();
        Rectangle tile;
        for (Integer x = 0; x < gridWidth; x++) {
            for (Integer y = 0; y < gridHeight; y++) {
                if (grid.state(x,y) == State.On) {
                    tile = new Rectangle(x * Simulation.tileSize,
                                         y * Simulation.tileSize,
                                         Simulation.tileSize,
                                         Simulation.tileSize);
                    g.setColor(State.OnColor);
                    g.fill(tile);
                    g.draw(tile);
                }
            }
        }
    }
}
