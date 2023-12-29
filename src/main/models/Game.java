package main.models;

import main.enums.CellState;
import main.enums.GameState;
import main.strategies.WinningStrategy;

import java.util.ArrayList;

public class Game {
    GameBoard gameBoard;
    ArrayList<Player> Players;
    ArrayList<WinningStrategy> winningStrategies;
    ArrayList<Move> moves;
    GameState gamestate;
    int size;

    public int getNextplayerindex() {
        return nextplayerindex;
    }

    public void setNextplayerindex(int nextplayerindex) {
        this.nextplayerindex = nextplayerindex;
    }

    int nextplayerindex;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }

    public ArrayList<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(ArrayList<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }
    public void makemove()
    {

        Player player=Players.get(nextplayerindex);
       Cell cell= player.makemove(this.gameBoard);
       Move latestMove = new Move(player,cell);
       moves.add(latestMove);

       for(WinningStrategy w:winningStrategies){
           if(w.checkWinner(latestMove,gameBoard)){
               gamestate = GameState.WIN;
           }
       }

       if(moves.size() == gameBoard.getSize()* gameBoard.getSize()){
           gamestate = GameState.DRAW;
       }



       nextplayerindex++;
       nextplayerindex = nextplayerindex%Players.size();



    }

    public void PrintBoard()
    {
        gameBoard.print();
    }

    public Game(ArrayList<Player> players, ArrayList<WinningStrategy> winningStrategies, int size) {
        Players = players;
        this.winningStrategies = winningStrategies;
        this.size = size;
        this.gamestate=GameState.INPROGRESS;
        this.gameBoard=new GameBoard(size);
        this.nextplayerindex=0;
        moves = new ArrayList<>();

    }

    public void makeUndo() {

        Move lastMove = getlastMove();
        undoCellandStrategy(lastMove);
        nextPlayerIndex();


    }

    public Move getlastMove(){
        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);
        return lastMove;
    }

    public void undoCellandStrategy(Move lastMove){
        Cell cell = lastMove.getCell();

        cell.setPlayer(null);
        cell.setCellstate(CellState.EMPTY);

        for(WinningStrategy w: winningStrategies){
            w.undo(lastMove, gameBoard);
        }
    }

    public void nextPlayerIndex(){
        if(nextplayerindex == 0){
            nextplayerindex = getPlayers().size()-1;
        }
        else{
            nextplayerindex--;
        }
    }
}
