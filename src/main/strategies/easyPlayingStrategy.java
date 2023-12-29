package main.strategies;

import main.enums.CellState;
import main.models.Cell;
import main.models.GameBoard;

public class easyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makemove(GameBoard gameboard) {
        for(int i=0;i<gameboard.getSize();i++){
            for(int j=0;j< gameboard.getSize();j++){
                if(gameboard.getCells().get(i).get(j).getCellstate().equals(CellState.EMPTY)){
                    return gameboard.getCells().get(i).get(j);
                }
            }
        }
        return null;
    }
}
