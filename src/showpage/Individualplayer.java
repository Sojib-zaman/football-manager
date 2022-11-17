package showpage;

import Subclass.Player;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Main;

import java.io.File;

public class Individualplayer {
    Main main ;
    @FXML
    public ImageView plimg;
    @FXML
    private Label Position;
@FXML
private Button prev ;
    @FXML
    private Label name;
    ObservableList<Player>data =  FXCollections.observableArrayList();
   

    public void backtoprv(ActionEvent event) throws Exception {
        main.showplayer(data);
    }

    public void setMain(Main main) {
        this.main  =  main ;
    }

    public void init(String selectedPlayername, String playerpos, ObservableList<Player> data)
    {
        this.data = data ;
        Image image = new Image(new File("img/"+selectedPlayername.toLowerCase() +".png").toURI().toString());
        plimg.setImage(image);
        name.setText(selectedPlayername);
        Position.setText(playerpos);
        plimg.setLayoutX(-100); plimg.setLayoutY(14);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setToX(100);transition.setToY(-5);transition.setNode(plimg);transition.play();

        name.setLayoutX(10); name.setLayoutY(-65);
        TranslateTransition transition2 = new TranslateTransition();
        transition2.setDuration(Duration.seconds(2));
        transition2.setToX(10);transition2.setToY(268);transition2.setNode(name);transition2.play();



    }


}
