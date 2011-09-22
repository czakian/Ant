import java.lang.reflect.Array;

class Ant {

	// An ant is represented by the coordinates of its location,
	// and the direction it is facing.
	Integer x;
	Integer y;
	Direction direction;

	// Represent direction as an enumeration
	enum Direction { X, Y, NegX, NegY };

	//Represent turn choice as an enumeration
	enum Turn { Pos, Neg };

	// Ant constructor
	Ant(Integer x, Integer y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	// Change this ant's direction
	private void turn(Turn turn) {
		//movement in the values from the enum
		int change = turn.equals(Turn.Neg) ? 1 : -1; 
		//grab the values out of the enum to iterate through
		Direction[] dirs = Direction.values();
		int arrLen = Array.getLength(dirs);

		for(int i = 0; i < arrLen; i++) {
			Direction d = dirs[i];
		
			if(d.equals(direction)) {	
				//guard against the array edges
				int index = change + i ;
				if(index == arrLen) 
					index = 0;
				else if (index < 0)
					index = arrLen - 1;

				direction = dirs[index];
				break;
			}
		}
	}

	// Mave this ant forward one step in the direction it is facing.
	// Sadly, Java's "%" is called "mod" but it is remainder.
	// That may explain the "+ width" and "+ height".
	private void forward(Integer width, Integer height) {
		switch (direction) {
			case X    : x = (x + 1 + width) % width;   break;
			case Y    : y = (y + 1 + height) % height; break;
			case NegX : x = (x - 1 + width) % width;   break;
			case NegY : y = (y - 1 + height) % height; break;
		}
	}

	// This ant turns then steps forward.
	void advance(State state, Integer width, Integer height) {
		//decide which way to go.
		Turn t = null;
		if (state.equals(State.On)) 
			t = Turn.Pos;
		else 
			t = Turn.Neg;
				
		turn(t);
		forward(width, height);
	}
}

