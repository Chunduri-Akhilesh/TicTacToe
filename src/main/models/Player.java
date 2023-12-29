package main.models;

import main.enums.CellState;
import main.enums.PLayerType;

import java.util.Scanner;

public class Player {
    char Symbol;
    String name;
    int id;
    PLayerType playerType;

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PLayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PLayerType playerType) {
        this.playerType = playerType;
    }

    public Player(char symbol, String name, int id, PLayerType playerType) {
        Symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
    }

    public Cell makemove(GameBoard gameboard) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Hi"+this.name+"Enter Input");
        int x=sc.nextInt();
        int y=sc.nextInt();

        while(!validInput(x, y,  gameboard)){
            System.out.println("Hi"+this.name+"Enter Input");
             x=sc.nextInt();
             y=sc.nextInt();
        }

        Cell cell=gameboard.getCells().get(x).get(y);
        cell.setCellstate(CellState.FILLED);
        cell.setPlayer(this);
        return cell;

    }
    public boolean validInput(int x,int y, GameBoard gameBoard){
        if(x> gameBoard.getSize()-1 || y>gameBoard.getSize()-1 || x<0 || y<0){
            return false;
        }
        if(gameBoard.getCells().get(x).get(y).getCellstate().equals(CellState.FILLED)){
            return false;
        }
        return true;
    }
}
