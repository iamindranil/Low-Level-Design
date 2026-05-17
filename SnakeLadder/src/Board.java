
public class Board {
	Cell[][] board;
	
	Board(int boardSize,int numberOfSnakes,int numberOfLadders){
		initializeBoard(boardSize);
		addSnakeAndLadders(board,numberOfSnakes,numberOfLadders);
	}

	private void addSnakeAndLadders(Cell[][] board, int numberOfSnakes, int numberOfLadders) {
		
	}

	private void initializeBoard(int boardSize) {
		board=new Cell[boardSize][boardSize];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++){
				board[i][j]=new Cell();
			}
		}
	}
}
