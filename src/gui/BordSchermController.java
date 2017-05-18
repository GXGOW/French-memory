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
    private int aantalGevondenParen=0;
    
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

        // <editor-fold defaultstate="collapsed" desc=" Invullen kaarten">
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                ImageView imageview = new ImageView(new Image("/images/achtergrond.png"));
                imageview.setOnMouseClicked(omDraaien);
                gridPane.add(imageview, j, i);
            }
        }
        // </editor-fold>
        stage.show();
    }

    final EventHandler<MouseEvent> omDraaien = new EventHandler<MouseEvent>() {
        @Override
        public void handle(final MouseEvent event) {
            System.out.println("je hebt geklikt");
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
        System.out.println("je hebt gecontroleerd");

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
                if(aantalGevondenParen ==15){
                    btnControlleer.setDisable(true);
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

//    private void vulImageIn(String id) {
//
//        switch (id) {
//
//            case "img00":
//                img00.setImage(new Image(lijst.get(0)));
//                break;
//            case "img01":
//                img01.setImage(new Image(lijst.get(1)));
//                break;
//            case "img02":
//                img02.setImage(new Image(lijst.get(2)));
//                break;
//            case "img03":
//                img03.setImage(new Image(lijst.get(3)));
//                break;
//            case "img04":
//                img04.setImage(new Image(lijst.get(4)));
//                break;
//            case "img05":
//                img05.setImage(new Image(lijst.get(5)));
//                break;
//            case "img10":
//                img10.setImage(new Image(lijst.get(6)));
//                break;
//            case "img11":
//                img11.setImage(new Image(lijst.get(7)));
//                break;
//            case "img12":
//                img12.setImage(new Image(lijst.get(8)));
//                break;
//            case "img13":
//                img13.setImage(new Image(lijst.get(9)));
//                break;
//            case "img14":
//                img14.setImage(new Image(lijst.get(10)));
//                break;
//            case "img15":
//                img15.setImage(new Image(lijst.get(11)));
//                break;
//            case "img20":
//                img20.setImage(new Image(lijst.get(12)));
//                break;
//            case "img21":
//                img21.setImage(new Image(lijst.get(13)));
//                break;
//            case "img22":
//                img22.setImage(new Image(lijst.get(14)));
//                break;
//            case "img23":
//                img23.setImage(new Image(lijst.get(15)));
//                break;
//            case "img24":
//                img24.setImage(new Image(lijst.get(16)));
//                break;
//            case "img25":
//                img25.setImage(new Image(lijst.get(17)));
//                break;
//            case "img30":
//                img30.setImage(new Image(lijst.get(18)));
//                break;
//            case "img31":
//                img31.setImage(new Image(lijst.get(19)));
//                break;
//            case "img32":
//                img32.setImage(new Image(lijst.get(20)));
//                break;
//            case "img33":
//                img33.setImage(new Image(lijst.get(21)));
//                break;
//            case "img34":
//                img34.setImage(new Image(lijst.get(22)));
//                break;
//            case "img35":
//                img35.setImage(new Image(lijst.get(23)));
//                break;
//            case "img40":
//                img40.setImage(new Image(lijst.get(24)));
//                break;
//            case "img41":
//                img41.setImage(new Image(lijst.get(25)));
//                break;
//            case "img42":
//                img42.setImage(new Image(lijst.get(26)));
//                break;
//            case "img43":
//                img43.setImage(new Image(lijst.get(27)));
//                break;
//            case "img44":
//                img44.setImage(new Image(lijst.get(28)));
//                break;
//            case "img45":
//                img45.setImage(new Image(lijst.get(29)));
//                break;
//        }
//
//    }
//
//    private void zetOpAchtergrond(String id) {
//
//        switch (id) {
//
//            case "img00":
//                img00.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img01":
//                img01.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img02":
//                img02.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img03":
//                img03.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img04":
//                img04.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img05":
//                img05.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img10":
//                img10.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img11":
//                img11.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img12":
//                img12.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img13":
//                img13.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img14":
//                img14.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img15":
//                img15.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img20":
//                img20.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img21":
//                img21.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img22":
//                img22.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img23":
//                img23.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img24":
//                img24.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img25":
//                img25.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img30":
//                img30.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img31":
//                img31.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img32":
//                img32.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img33":
//                img33.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img34":
//                img34.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img35":
//                img35.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img40":
//                img40.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img41":
//                img41.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img42":
//                img42.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img43":
//                img43.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img44":
//                img44.setImage(new Image("/images/achtergrond.png"));
//                break;
//            case "img45":
//                img45.setImage(new Image("/images/achtergrond.png"));
//                break;
//        }
//    }
}
