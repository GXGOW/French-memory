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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private ImageView tijdelijk;
    // <editor-fold defaultstate="collapsed" desc=" attributen FXML ">
    @FXML
    private GridPane gridPane;
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
        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++){
                ImageView imageview =  new ImageView(new Image("/images/achtergrond.png"));
                gridPane.add(imageview, j, i);
            }
        }
        // </editor-fold>
        stage.show();
    }

    private void draaiOm(MouseEvent event) {
//        ++teller;
//
//        ImageView imgView = (ImageView) event.getSource();
//        if (teller == 1) {
//            tijdelijk = imgView;
//        }
//        vulImageIn(imgView.getId());
//        if (teller == 2) {
//           
//            zetOpAchtergrond(tijdelijk.getId());
//            zetOpAchtergrond(imgView.getId());
//            teller = 0;
//        }
    }
    
    private void zetOpAchtergrond(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
