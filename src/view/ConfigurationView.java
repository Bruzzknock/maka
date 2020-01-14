package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sample.Main;

import java.io.IOException;

public class ConfigurationView {

    private Main mainApp;
    private int noColumns;
    private int noRows;

    @FXML
    private TextField columnsField;

    @FXML
    private TextField rowsField;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleConfirm()
    {
        int columns =  Integer.parseInt(columnsField.getText());
        int rows =  Integer.parseInt(rowsField.getText());

        GameLogic gl = new GameLogic();

        noColumns = columns;
        noRows = rows;

        Main mainApp = Main.getMainApp();
        Stage pStage = Main.getpStage();

        BorderPane root = new BorderPane();
        GridPane grid = (GridPane)gl.initMatrix(columns,rows);
        BorderPane.setAlignment(grid, Pos.CENTER);
        root.setCenter(grid);

        Scene scene = new Scene(root,800.00,600.00);

        pStage.setTitle("Game done by Maka");
        pStage.setScene(scene);
        pStage.show();
    }

    public int getNoColumns() {
        return noColumns;
    }

    public int getNoRows() {
        return noRows;
    }
}
