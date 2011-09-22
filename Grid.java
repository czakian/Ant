class Grid {

    // The grid is represented as a 2-dimensional array of States
    State[][] grid;

    // Construct a new Grid object with all States set to Off
    Grid(Integer width, Integer height) {
			grid = new State[width][height];

			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					grid[i][j] = State.Off;
				}
			}
    }

    // Return the State at a given coordinate of the grid
		//there is no error checking for ends of the arrays here.
		//I assume it isn't necessary as there aren't any height and width fields.
		//of course you could derive it with 
		//Array.getLength(grid); and Array.getLenght(grid[0]);
    State state(Integer x, Integer y) {
			return grid[x][y];
    }

    // Update a grid element to the next state
    void update(Integer x, Integer y) {
				grid[x][y] = grid[x][y].next();
    }
}
