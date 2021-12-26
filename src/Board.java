/**
 * @File: Board.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Abstract data type representation of a 4x4 board filled with tiles.
 */

package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
	
	private Tile[][] board;
	private boolean won;
	private int score;
	
	/**
	 * @brief Board constructor.
	 * @details Generates a new board, setting up state variables. Generates 2 random pieces that are placed on the board.
	 */
	public Board() {
		board = new Tile[4][4];
		won = false;
		score = 0;
		generateRandomPiece(2);
	}
	
	/**
	 * @brief Gets the tile at the given Position.
	 * @param p - Position of Tile
	 * @return a Tile at the specified Position.
	 */
	public Tile getTile(Position p) {
		return board[p.getX()][p.getY()];
	}
	
	/**
	 * @brief Places a tile on the board.
	 * @param t - Tile
	 */
	public void placeTile(Tile t) {
		board[t.getPosition().getX()][t.getPosition().getY()] = t;
	}
	
	/**
	 * @brief Moves a tile from the tile's Position to the new specified Position.
	 * @param tile - Tile to move
	 * @param p - new Position to move the tile to
	 */
	public void moveTile(Tile tile, Position p) {
		board[tile.getPosition().getX()][tile.getPosition().getY()] = null;
		Tile tileCopy = new Tile(p, tile.getValue());
		placeTile(tileCopy);
	}
	
	/**
	 * @brief Moves the specified Tile in the given Direction.
	 * @param t - Tile to move
	 * @param d - Direction to move the Tile in
	 */
	public void moveTileGivenDirection(Tile t, Direction d) {
		Position newPosition = calculateFinalTilePosition(t, d);
		if(getTile(newPosition) != null) {
			Tile tile = getTile(newPosition);
			if(tile != t && t.equals(tile)) { 
				t.combine(tile);
				score += t.getValue();
				if(t.getValue() == 2048) won = true;
			}
		}
		moveTile(t, newPosition);
		t.setPosition(newPosition);
	}
	
	/**
	 * @brief The current score of the Board.
	 * @return an Integer, representing the Board's score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * @brief Checks if the Board has achieved a 2048 tile.
	 * @return a boolean that is true if a 2048 tile has been reached.
	 */
	public boolean checkWin() {
		return won;
	}
	
	/**
	 * @brief Moves all Board Tile pieces in the given Direction. The moveBoard function considers the Tiles in the Direction specified. That is, if the Direction specified is left, the
	 * moveBoard function updates the Tiles from right to left. Each Tile move is kept track of. If the number of moves made is greater than zero, then a new Tile is spawned randomly.
	 * @param d - Direction to move the board
	 */
	public void moveBoard(Direction d) {
		int moves = 0;
		
		int columnVector = 0;
		int rowVector = 0;
		
		int curColumn = 0;
		int curRow = 0;
		
		boolean horizontal = d == Direction.left || d == Direction.right;
		
		if(horizontal) {
			columnVector = d == Direction.left ? 1 : -1;
			curColumn = d == Direction.left ? 0 : 3;
		}else {
			rowVector = d == Direction.up ? 1 : -1;
			curRow = d == Direction.up ? 0 : 3;
		}
		
		int i = 0;
		while(i <= 3) {
			if(horizontal) {
				for(Tile t : getTilesInColumn(curColumn)) {
					if(t != null && canTileMove(t, d)) {
						moveTileGivenDirection(t, d);
						moves++;
					}
				}
			}else {
				for(Tile t : getTilesInRow(curRow)) {
					if(t != null && canTileMove(t, d)) {
						moveTileGivenDirection(t, d);
						moves++;
					}
				}
			}
			curRow += rowVector;
			curColumn += columnVector;
			i++;
		}
		if(moves > 0) generateRandomPiece(1);
	}
	
	/**
	 * @brief Gets all possible moves available for the board.
	 * @return an Integer
	 */
	public int getPossibleMoves() {
		int moves = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				Position current = new Position(i, j);
				Tile currentTile = getTile(current);
				if(currentTile == null) continue;
				moves += getMovesForTile(currentTile);
			}
		}
		return moves;
	}
	
	/**
	 * @brief Prints out the Board in a text format to the terminal.
	 */
	public void print() {
		System.out.println("---------------------------");
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 3; j++) {
				Position pos = new Position(j, i);
				String value = getTile(pos) == null ? " " : "" + getTile(pos).getValue();
				System.out.print("[" + value + "] ");
			}
			System.out.println();
		}
		System.out.println("Score: " + score);
		System.out.println("---------------------------");
	}
	
	private Tile[] getTilesInColumn(int column) {
		if(column < 0 || column > 3) throw new IndexOutOfBoundsException("Cannot get specified column of board");
		return board[column];
	}
	
	private Tile[] getTilesInRow(int row) {
		if(row < 0 || row > 3) throw new IndexOutOfBoundsException("Cannot get specified row of board");
		return new Tile[] {board[0][row], board[1][row], board[2][row], board[3][row]};
	}
	
	private int getMovesForTile(Tile t) {
		int moves = 0;
		int i = t.getPosition().getX();
		int j = t.getPosition().getY();
		Position left = new Position(i-1, j);
		Position right = new Position(i+1, j);
		Position up = new Position(i, j-1);
		Position down = new Position(i, j+1);
		if(!left.equals(t.getPosition()) && (getTile(left) == null || getTile(left).equals(t)))  moves++;
		if(!right.equals(t.getPosition()) && (getTile(right) == null || getTile(right).equals(t)))  moves++;
		if(!up.equals(t.getPosition()) && (getTile(up) == null || getTile(up).equals(t)))  moves++;
		if(!down.equals(t.getPosition()) && (getTile(down) == null || getTile(down).equals(t)))  moves++;
		return moves;
	}
	
	private boolean canTileMove(Tile t, Direction d) {
		return !calculateFinalTilePosition(t, d).equals(t.getPosition());
	}
	
	private Position calculateFinalTilePosition(Tile t, Direction d) {
		int xVector = d.getX();
		int yVector = d.getY();
		
		Position finalPosition = new Position(t.getPosition().getX(), t.getPosition().getY());
		while(true) {
			if(xVector < 0 && finalPosition.getX() == 0) break;
			else if(xVector > 0 && finalPosition.getX() == 3) break;
			else if(yVector < 0 && finalPosition.getY() == 0) break;
			else if(yVector > 0 && finalPosition.getY() == 3) break;
			
			finalPosition.addX(xVector);
			finalPosition.addY(yVector);
			
			if(getTile(finalPosition) != null) {
				if(!getTile(finalPosition).equals(t)) {
					finalPosition.addX(-xVector);
					finalPosition.addY(-yVector);
				}
				break;
			}
		}
		return finalPosition;
	}
	
	private void generateRandomPiece(int numPieces) {
		if(numPieces < 0) throw new ArithmeticException("numPieces must be a natural number.");
		Random random = new Random();
		for(int i = 0; i < numPieces; i++) {
			ArrayList<int[]> emptyCoords = getEmptyCoordinates();
			if(emptyCoords.isEmpty()) {
				return;
			}
			int[] randomCoords = emptyCoords.get(random.nextInt(emptyCoords.size()));
			int x = randomCoords[0];
			int y = randomCoords[1];
			Tile randomTile = new Tile(new Position(x, y), (int) Math.pow(2, 1));
			placeTile(randomTile);
		}
	}
	
	private ArrayList<int[]> getEmptyCoordinates() {
		ArrayList<int[]> emptyCoords = new ArrayList<int[]>();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(getTile(new Position(j, i)) == null) emptyCoords.add(new int[] {j, i});
			}
		}
		return emptyCoords;
	}
}
