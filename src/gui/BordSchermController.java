/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alyssia
 */
public class BordSchermController extends Pane {

    private final DomeinController controller;
    private List<String> lijst = new ArrayList<>();
    private ImageView eersteOmgedraaid;
    private ImageView tweedeOmgedraaid;
    private int aantalGevondenParen = 0;

    // <editor-fold defaultstate="collapsed" desc=" attributen FXML ">
    @FXML
    private GridPane gridPane;
    @FXML
    private Label lblMelding;
    @FXML
    private Button btnControlleer;
    @FXML
    private Label lblEinde;
    // </editor-fold>

    public BordSchermController(DomeinController controller, Stage stage) {
        this.controller = controller;
        // <editor-fold defaultstate="collapsed" desc=" FXML laden">
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("BordScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        lijst = this.controller.selecteer();
        long seed = System.nanoTime();
        Collections.shuffle(lijst, new Random(seed));
        // </editor-fold>       

        // <editor-fold defaultstate="collapsed" desc=" Code invullen met wacht -> werkt NIET">
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 5; j++) {
//                int indexLijst = i * 5 + j;
//                ImageView imageview = new ImageView(new Image(lijst.get(indexLijst)));
//                imageview.setOnMouseClicked(omDraaien);
//                gridPane.add(imageview, j, i);
//            }
//        }
//        stage.show();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(BordSchermController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 5; j++) {
//                int indexLijst = i * 5 + j;
//                ImageView imgView = (ImageView) gridPane.getChildren().get(indexLijst);
//                imgView.setImage(new Image("/images/achtergrond.png"));
//                imgView.setOnMouseClicked(omDraaien);
//            }
//        }
        // </editor-fold>
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                ImageView imgView = new ImageView(new Image("/images/achtergrond.png"));
                imgView.setOnMouseClicked(omDraaien);
                gridPane.add(imgView, j, i);
            }
        }
        stage.show();
    }

    final EventHandler<MouseEvent> omDraaien = new EventHandler<MouseEvent>() {
        @Override
        public void handle(final MouseEvent event) {
            ImageView imgView = (ImageView) event.getSource();
            int rij = GridPane.getRowIndex(imgView);
            int kolom = GridPane.getColumnIndex(imgView);
            int indexLijst = rij * 5 + kolom;
            if (eersteOmgedraaid == null) {
                imgView.setImage(new Image(lijst.get(indexLijst)));
                eersteOmgedraaid = imgView;
            } else if (tweedeOmgedraaid == null) {
                imgView.setImage(new Image(lijst.get(indexLijst)));
                tweedeOmgedraaid = imgView;
            } else {
                lblMelding.setText("Tu as déjà tourné deux cartes. D'abord controlle les ... ");
            }
        }
    };

    @FXML
    private void controlleer(ActionEvent event) {
        if (eersteOmgedraaid == null || tweedeOmgedraaid == null) {
            lblMelding.setText("Tu n'a pas tourné deux cartes!");
        } else {
            int rijEerste = GridPane.getRowIndex(eersteOmgedraaid);
            int kolomEerste = GridPane.getColumnIndex(eersteOmgedraaid);
            int indexLijstEerste = rijEerste * 5 + kolomEerste;

            int rij = GridPane.getRowIndex(tweedeOmgedraaid);
            int kolom = GridPane.getColumnIndex(tweedeOmgedraaid);
            int indexLijst = rij * 5 + kolom;
            if (controller.isPaar(lijst.get(indexLijst), lijst.get(indexLijstEerste))) {
                //Deze twee niet meer aanklikken!
                eersteOmgedraaid.setOnMouseClicked(null);
                tweedeOmgedraaid.setOnMouseClicked(null);
                lblMelding.setText("Bravo! Ces deux cartes sont un couple!");
                aantalGevondenParen++;
                if (aantalGevondenParen == 15) {
                    btnControlleer.setVisible(false);
                    lblMelding.setVisible(false);
                    gridPane.setVisible(false);
                    lblEinde.setText("Bravo!!!! Vous avez trouvé tous les couples!!!");
                }
            } else {
                lblMelding.setText("Dommage! Ces deux cartes ne sont pas un couple!");
                eersteOmgedraaid.setImage(new Image("/images/achtergrond.png"));
                tweedeOmgedraaid.setImage(new Image("/images/achtergrond.png"));

            }
            eersteOmgedraaid = null;
            tweedeOmgedraaid = null;
        }
    }
}
