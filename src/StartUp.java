
import domein.DomeinController;
import gui.BordSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alyssia
 */
public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene;
        DomeinController controller = new DomeinController();

        scene = new Scene(new BordSchermController(controller, primaryStage));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(StartUp.class, args);
    }
}
