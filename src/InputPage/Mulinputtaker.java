package InputPage;
import Search.playersearcher;
import Subclass.Player;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;

import java.util.ArrayList;
import java.util.List;

public class Mulinputtaker {
    Main main ;
    List<Player>playerList ;
    private String orderer;
    @FXML
    private Label upper;

    @FXML
    private Label lower;
    @FXML
    private Button submit;

    @FXML
    private Button reset;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;
    @FXML
    void pressreset(ActionEvent event) {

        txt1.setText("");
        txt2.setText("");
    }

    @FXML
    void presssubmit(ActionEvent event) throws Exception {
        String validinput1 = txt1.getText().trim();
        String validinput2 = txt2.getText().trim();
        List<Player> players =new ArrayList<>();



            players = new playersearcher(playerList).salaryplayer(validinput1,validinput2);


        main.showplayer(players);

    }

    public void setMain(Main main) {
        this.main = main ;
    }

    public void init(String required, List<Player> playerList) {
        if(required.equals("salary"))
        {
            upper.setText("lowest amount");
            lower.setText("Highest amount");
        }
        orderer = required;
        this.playerList = playerList;

    }
}
