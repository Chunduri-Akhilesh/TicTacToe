package main.models;

import java.util.ArrayList;

public class GameBoard {
    int size;
    ArrayList<ArrayList<Cell>> cells;

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ArrayList<Cell>> cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print() {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                cells.get(i).get(j).print();

            }
            System.out.println();
        }

    }

    public GameBoard(int size) {
        this.size = size;
        cells=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            cells.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++)
        {//cells.add(new ArrayList<>());

            for(int j=0;j<size;j++)
            {
                cells.get(i).add(new Cell(i,j));

            }

        }
    }
}
