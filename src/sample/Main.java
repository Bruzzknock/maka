package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
    }

    private void showMainMenu()
    {
        /*try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/ExaminationOverview.fxml"));
            TabPane examinationOverview = (TabPane) loader.load();

            examinationsController = loader.getController();
            examinationsController.setMainApp(this);

            primaryStage.setScene(new Scene(examinationOverview));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
