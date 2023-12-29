package main.strategies;

import main.models.GameBoard;
import main.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    HashMap<Character, HashMap<Integer,Integer>> rowCount;
    @Override
    public boolean checkWinner(Move move, GameBoard gameBoard) {
        int row = move.getCell().getRow();

        if(rowCount.containsKey(move.getPlayer().getSymbol())){
            HashMap<Integer,Integer> rows = rowCount.get(move.getPlayer().getSymbol());

            if(rows.containsKey(row)){
                rows.put(row,rows.get(row)+1);
            }
            else{
                rows.put(row,1);
            }

            if(rows.get(row) == gameBoard.getSize()){
                return true;
            }
        }
        else{
            HashMap<Integer,Integer> rows = new HashMap<>();
            rows.put(row,1);
            rowCount.put(move.getPlayer().getSymbol(),rows);

        }
        return false;
    }

    @Override
    public void undo(Move move, GameBoard gameBoard) {
        Character symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        rowCount.get(symbol).put(row,rowCount.get(symbol).get(row)-1);
    }

    public RowWinningStrategy() {
        this.rowCount = new HashMap<>();
    }
}
