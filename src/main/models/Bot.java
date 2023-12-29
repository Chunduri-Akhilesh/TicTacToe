package main.models;

import main.enums.BotPlayingStrategies;
import main.enums.CellState;
import main.enums.PLayerType;
import main.strategies.BotPlayingStrategy;
import main.strategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    BotPlayingStrategies difficulty;

    BotPlayingStrategy botPlayingStrategy;

    @Override
    public Cell makemove(GameBoard gameboard) {

        System.out.println("wait for bot");
        Cell cell = botPlayingStrategy.makemove(gameboard);

        cell.setPlayer(this);
        cell.setCellstate(CellState.FILLED);

        return cell;
    }

    public Bot(char symbol, String name, int id, PLayerType playerType, BotPlayingStrategies difficulty) {
        super(symbol, name, id, playerType);
        this.difficulty = difficulty;

        this.botPlayingStrategy = BotPlayingStrategyFactory.botPlayingStrategy(difficulty);

    }
}
