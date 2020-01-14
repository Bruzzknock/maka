package entity;

import javafx.scene.control.Button;

public class IndexButton extends Button
{
    int column;
    int row;

    public IndexButton(String text, int column, int row)
    {
        super(text);
        this.column = column;
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public int getRow()
    {
        return row;
    }
}
