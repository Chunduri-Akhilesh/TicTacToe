package main.strategies;

import main.models.Cell;
import main.models.GameBoard;

public interface BotPlayingStrategy {
    public Cell makemove(GameBoard gameboard);
}
