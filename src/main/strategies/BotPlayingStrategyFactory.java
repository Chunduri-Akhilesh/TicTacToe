package main.strategies;

import main.enums.BotPlayingStrategies;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy botPlayingStrategy(BotPlayingStrategies strategy){
        return new easyPlayingStrategy();
    }
}
