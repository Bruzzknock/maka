package logic;

import entity.IndexButton;
import entity.Memory;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.Random;

public class GameLogic {
    GridPane grid = new GridPane();
    int[][] matrix;
    int columns;
    int rows;
    int player;
    int numberOfMoves = 0;
    boolean isAlreadySelected = false;
    Memory sourceField = new Memory();
    Memory targetField = new Memory();

    public Pane initMatrix(int columns, int rows)
    {
        grid.setAlignment(Pos.CENTER);

        Random rand = new Random();
        this.columns = columns;
        this.rows = rows;
        matrix = new int[columns][rows];

        for (int i = 0; i < columns;i++)
        {
            for(int j = 0; j < rows;j++)
            {
                IndexButton iButton;

                if(i != 0 || j != 0 )
                {
                    int randValue = rand.nextInt(100);
                    iButton = new IndexButton(Integer.toString(randValue),i,j);
                    grid.add(iButton,i,j);
                    matrix[i][j] = randValue;
                }
                else
                {
                    player = rand.nextInt(100);
                    iButton = new IndexButton(Integer.toString(player),i,j);
                    grid.add(iButton,i,j);
                    matrix[i][j] = player;
                }

                iButton.setOnAction(event -> {
                    if(isAlreadySelected)
                    {
                        targetField = new Memory();
                       targetField.setColumn(iButton.getColumn());
                       targetField.setRow(iButton.getRow());
                       targetField.setValue(Integer.parseInt(iButton.getText()));

                       updateGame();
                    }
                    else
                    {
                        sourceField = new Memory();
                        sourceField.setColumn(iButton.getColumn());
                        sourceField.setRow(iButton.getRow());
                        sourceField.setValue(Integer.parseInt(iButton.getText()));
                    }
                    isAlreadySelected = isAlreadySelected ? false : true;
                });
            }
        }

        return grid;
    }

    private Node getNodeByRowColumnIndex (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    private void updateGame()
    {
        int changeValue = sourceField.getValue();
        updateFields(targetField.getColumn(),targetField.getRow(),targetField.getValue(),changeValue);
        //matrix[targetField.getColumn()][targetField.getRow()] = changeValue;

        if(isGameOver())
        {
            Platform.exit();
            System.exit(0);
        }

        targetField = null;
        sourceField = null;
        numberOfMoves++;
    }

    private void updateButton(int column,int row, int value)
    {
        IndexButton iButton = (IndexButton)getNodeByRowColumnIndex(row,column,grid);
        iButton.setText(Integer.toString(value));
    }

    private void updateFields(int column, int rows,int value, int changedValue)
    {
        int minCol = column == 0 ? column : column - 1;
        int maxCol = (column+1) > this.columns-1 ? column : column + 1;
        int minRow = rows == 0 ? rows : rows - 1;
        int maxRow = (rows+1) > this.rows-1 ? rows : rows + 1;

        for(int i = minCol; i <= maxCol;i++)
        {
            for(int j =minRow;j <= maxRow;j++)
            {
                if(matrix[i][j] == value)
                {
                    matrix[i][j] = changedValue;
                    updateButton(i,j,changedValue);
                }

                //matrix[i][j] = matrix[i][j] == value ? changedValue : matrix[i][j];
            }
        }
    }

    private boolean isGameOver()
    {
        for (int i = 0; i < columns;i++)
        {
            for(int j = 0; j < rows;j++)
            {
                if(matrix[i][j] != player)
                    return false;
            }
        }

        return true;
    }
}
