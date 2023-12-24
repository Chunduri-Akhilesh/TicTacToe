package main.Controllers;

import main.enums.PLayerType;
import main.models.Game;
import main.models.Player;

import java.util.ArrayList;

public class GameController {
    public static void main(String[] args) {
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player('x',"Akhi",1, PLayerType.PLAYER ));
        players.add(new Player('o',"Adi",2, PLayerType.BOT ));
      //  players.add(new Player('x',"Akhi",1, PLayerType.PLAYER ));
        Game game=new Game(players,null,3);
        game.PrintBoard();

    }
}
