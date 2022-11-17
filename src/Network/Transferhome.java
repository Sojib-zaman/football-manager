package Network;

import Network.Client;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.Main;

import java.io.IOException;

public class Transferhome {

    @FXML
    private Label translabel;
    Main main ;
    String clubname ;
    Client client ;
    @FXML
    private Button buybutton;
    @FXML
    private Button sellbutton;

    public void setMain(Main main)
    {
        this.main = main ;
    }

    public void BUYPLAYERclicked(ActionEvent event) throws IOException
    {
        main.showavailableplayerstobuy(client);
    }

    public void SELLPLAYERclicked(ActionEvent event) throws IOException {
        main.showplayerstosell(client) ;
    }


    public void init(String clubname, Client client) {
        this.clubname = clubname ;
        this.client = client ;
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(buybutton);
        rotate.setDuration(Duration.millis(1000));
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(sellbutton);
        rotate2.setDuration(Duration.millis(1000));
        rotate2.setByAngle(-360);
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.play();

    }

    public void backtohome(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }


}
