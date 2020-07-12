package project.model;


public class Model {
	
	Tile[][] board;
	Location emptyTile;
	boolean locked;
	int numOfMoves;
	

	public Model() {
		board = new Tile[3][3]; //[row][col] 
		emptyTile = new Location(0, 0);
		locked = false;
		populateBoard();		
	}
	
	public void populateBoard() {
		board[0][0] = new Tile(1, false, 0, 0);
		board[0][1] = new Tile(4, true, 0, 1);
		board[0][2] = new Tile(3, false, 0, 2);
		
		board[1][0] = new Tile(2, false, 1, 0);
		board[1][1] = new Tile(1, true, 1, 1);
		board[1][2] = new Tile(4, false, 1, 2);
		
		board[2][0] = new Tile(0, false, 2, 0);
		board[2][1] = new Tile(2, false, 2, 1);
		board[2][2] = new Tile(3, false, 2, 2);
		
		emptyTile.setRow(2);
		emptyTile.setCol(0); 
	
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Tile getTile(Location loc) {
		return board[loc.getRow()][loc.getCol()];
	}
	
	public Tile getTile(int row, int col) {
		return board[row][col];
	}

	public Location getEmpty() {
		return  emptyTile;
	}
	
	public void setEmptyTile(int row, int col) {
		emptyTile.row = row;
		emptyTile.col = col;
	}
	
	public void setTile(Location loc, Tile tile) {
		board[loc.getRow()][loc.getCol()] = tile;
	}
	public int getNumOfMoves() {
		return numOfMoves;
	}

	public void setNumOfMoves(int numOfMoves) {
		this.numOfMoves = numOfMoves;
	}
	
}