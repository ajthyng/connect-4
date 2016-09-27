package connectfour;
import java.util.*;

public class AI extends Player{
	
	public AI(){
		super(2,"Computer",'X');
	}
	
	public AI(char pieceType){
		super(2,"Computer",pieceType);
	}
	
	public AI(String name,char pieceType){
		super(2,name,pieceType);
	}

	public void placePiece(GameEngine game) {
		// Start with a list of all columns
		ArrayList<Integer> columns = new ArrayList<Integer>(
				Arrays.asList(0,1,2,3,4,5,6));
		boolean success;
		do{
			// Pick a random column
			int col = getRandom(columns);
			// Try putting a piece in that column. If it doesn't work, remove 
			// that column from possibilities and pick a different column.
			success = game.placePiece(col, pieceType);
			if (! success){
				columns.remove(col);
			}
			// if successful add that pick to history
			else
				history.add(col);
		} while (! success);
	}
	
	private int getRandom(ArrayList<Integer> array){
		int rand = new Random().nextInt(array.size());
		return array.get(rand);
	}
}
