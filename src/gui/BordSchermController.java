/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alyssia
 */
public class BordSchermController extends Pane {

    private final DomeinController controller;
    // <editor-fold defaultstate="collapsed" desc=" attributen FXML ">
    @FXML
    private ImageView img00;
    @FXML
    private ImageView img01;
    @FXML
    private ImageView img02;
    @FXML
    private ImageView img03;
    @FXML
    private ImageView img04;
    @FXML
    private ImageView img05;
    @FXML
    private ImageView img15;
    @FXML
    private ImageView img14;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img25;
    @FXML
    private ImageView img24;
    @FXML
    private ImageView img23;
    @FXML
    private ImageView img22;
    @FXML
    private ImageView img21;
    @FXML
    private ImageView img20;
    @FXML
    private ImageView img35;
    @FXML
    private ImageView img34;
    @FXML
    private ImageView img33;
    @FXML
    private ImageView img32;
    @FXML
    private ImageView img31;
    @FXML
    private ImageView img30;
    @FXML
    private ImageView img45;
    @FXML
    private ImageView img44;
    @FXML
    private ImageView img43;
    @FXML
    private ImageView img42;
    @FXML
    private ImageView img41;
    @FXML
    private ImageView img40;
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
        // </editor-fold>       

        // <editor-fold defaultstate="collapsed" desc=" Invullen kaarten">
        vulImagesIn();
        // </editor-fold>
        stage.show();
    }

    @FXML
    private void draaiOm(MouseEvent event) {

    }

    private void vulImagesIn() {
        List<String> lijst = this.controller.selecteer();
        long seed = System.nanoTime();
        Collections.shuffle(lijst, new Random(seed));
        img00.setImage(new Image(lijst.get(0)));
        img01.setImage(new Image(lijst.get(1)));
        img02.setImage(new Image(lijst.get(2)));
        img03.setImage(new Image(lijst.get(3)));
        img04.setImage(new Image(lijst.get(4)));
        img05.setImage(new Image(lijst.get(5)));
        img10.setImage(new Image(lijst.get(6)));
        img11.setImage(new Image(lijst.get(7)));
        img12.setImage(new Image(lijst.get(8)));
        img13.setImage(new Image(lijst.get(9)));
        img14.setImage(new Image(lijst.get(10)));
        img15.setImage(new Image(lijst.get(11)));
        img20.setImage(new Image(lijst.get(12)));
        img21.setImage(new Image(lijst.get(13)));
        img22.setImage(new Image(lijst.get(14)));
        img23.setImage(new Image(lijst.get(15)));
        img24.setImage(new Image(lijst.get(16)));
        img25.setImage(new Image(lijst.get(17)));
        img30.setImage(new Image(lijst.get(18)));
        img31.setImage(new Image(lijst.get(19)));
        img32.setImage(new Image(lijst.get(20)));
        img33.setImage(new Image(lijst.get(21)));
        img34.setImage(new Image(lijst.get(22)));
        img35.setImage(new Image(lijst.get(23)));
        img40.setImage(new Image(lijst.get(24)));
        img41.setImage(new Image(lijst.get(25)));
        img42.setImage(new Image(lijst.get(26)));
        img43.setImage(new Image(lijst.get(27)));
        img44.setImage(new Image(lijst.get(28)));
        img45.setImage(new Image(lijst.get(29)));
    }
}
