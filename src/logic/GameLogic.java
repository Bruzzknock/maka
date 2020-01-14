package logic;

import entity.IndexButton;
import entity.Memory;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GameLogic {
    int[][] matrix;
    int player;
    boolean isAlreadySelected = false;
    Memory sourceField;
    Memory targetField;

    public Pane initMatrix(int columns, int rows)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        Random rand = new Random();

        matrix = new int[columns][rows];

        for (int i = 0; i < columns;i++)
        {
            for(int j = 0; j < rows;j++)
            {
                IndexButton iButton;

                if(i != 0 || j != 0 )
                {
                    iButton = new IndexButton(Integer.toString(rand.nextInt(100)),i,j);
                    grid.add(iButton,i,j);
                }
                else
                {
                    player = rand.nextInt(100);
                    iButton = new IndexButton(Integer.toString(player),i,j);
                    grid.add(iButton,i,j);
                }

                iButton.setOnAction(event -> {
                    if(isAlreadySelected)
                    {
                       targetField.setColumn(iButton.getColumn());
                       targetField.setRow(iButton.getColumn());
                       targetField.setValue(Integer.parseInt(iButton.getText()));

                       updateGame();
                    }
                    else
                    {
                        sourceField.setColumn(iButton.getColumn());
                        sourceField.setRow(iButton.getColumn());
                        sourceField.setValue(Integer.parseInt(iButton.getText()));
                    }
                    isAlreadySelected = isAlreadySelected ? false : true;
                });
            }
        }

        return grid;
    }

    private void updateGame()
    {
        
    }
}
