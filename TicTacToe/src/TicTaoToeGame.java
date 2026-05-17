import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Model.Board;
import Model.Player;
import Model.PlayingPieceO;
import Model.PlayingPieceX;
public class TicTaoToeGame {
	Deque<Player> players;
	Board board;
	
	public TicTaoToeGame() {
		initializeGame();
	}
	
	private void initializeGame() {
		players=new LinkedList<Player>();
		
		
		Player player1=new Player("player1",new PlayingPieceX());
		Player player2=new Player("player2",new PlayingPieceO());
		
		players.add(player2);
		players.add(player1);
	
		board=new Board(3);
		
	}
	
	public void startGame() {
		boolean hasWinner=false;
		
		while(!hasWinner) {
			Player playerTurn=players.removeFirst();
			//logic for the game
			
			
		}
	}
}
