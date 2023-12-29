package main.strategies;

import main.models.GameBoard;
import main.models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, GameBoard gameBoard);

    public void undo(Move move, GameBoard gameBoard);
}
