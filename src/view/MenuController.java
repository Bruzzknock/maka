package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class MenuController {


    @FXML
    private void handleStart()
    {
        Main mainApp = Main.getMainApp();
        Stage pStage = Main.getpStage();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/configuration-view.fxml"));
            BorderPane configurationOverview = (BorderPane) loader.load();

            ConfigurationView configurationView = loader.getController();
            configurationView.setMainApp(mainApp);

            pStage.setScene(new Scene(configurationOverview));
            pStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExit()
    {
        Platform.exit();
        System.exit(0);
    }
}
