package main.models;

public class Move {
    Player player;
    Cell cell;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }
}
