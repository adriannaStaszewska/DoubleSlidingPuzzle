package project.model;

public class Tile {
	int top;
	int down;
	Location location;
	boolean flipState;
	
	
	public Tile(int top, boolean flipState, int row, int col) {
		super();
		this.top = top; 
		this.down = 5-top;
		this.flipState = flipState;
		location = new Location(row, col);
	}
	
	public void flip() {
		flipState = !flipState;
		top = down;
		down = 5-top;
	}
	
	public void move(int row, int col) {
		location.setRow(row);
		location.setCol(col);
	}
	
	public int getRow() {
		return location.row;
	}

	public void setRow(int row) {
		this.location.row = row;
	}

	public int getCol() {
		return location.col;
	}

	public void setCol(int col) {
		this.location.col = col;
	}

	public boolean isFlipState() {
		return flipState;
	}

	public void setFlipState(boolean flipState) {
		this.flipState = flipState;
	}

	public int getTop() {
		return top;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location loc) {
		location = loc;
	}
	
}
