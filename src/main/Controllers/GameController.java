package main.Controllers;

import main.enums.BotPlayingStrategies;
import main.enums.GameState;
import main.enums.PLayerType;
import main.models.Bot;
import main.models.Game;
import main.models.Player;
import main.strategies.RowWinningStrategy;
import main.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player('x',"Akhi",1, PLayerType.PLAYER ));
        players.add(new Bot('o',"Adi",2, PLayerType.BOT, BotPlayingStrategies.EASY));
      //  players.add(new Player('x',"Akhi",1, PLayerType.PLAYER ));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        Game game=new Game(players,winningStrategies,3);
        game.PrintBoard();

        while(game.getGamestate().equals(GameState.INPROGRESS)){
            System.out.println("do you want to undo ?");

            Scanner sc = new Scanner(System.in);

            String choice = sc.next();

            if(choice.equalsIgnoreCase("y")){
                game.makeUndo();
            }
            else {
                game.makemove();
            }
            game.PrintBoard();
        }

        if(game.getGamestate().equals(GameState.DRAW)){
            System.out.println("game is drawn");
        }

        if(game.getGamestate().equals(GameState.WIN)){
            System.out.println("you won");
        }


    }
}
