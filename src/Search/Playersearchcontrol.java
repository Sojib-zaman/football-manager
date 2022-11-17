package Search;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;
import sample.Main;
import Subclass.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Playersearchcontrol {

    Main main ;
    List<Player> playerList = new ArrayList();
    @FXML
    private Button byplayername;

    @FXML
    private Button clubcountry;

    @FXML
    private Button bypos;

    @FXML
    private Button salsearch;

    @FXML
    private Button countplayer;

    @FXML
    private Button tohome;

    @FXML
    void backtomainmenu(ActionEvent event) throws IOException {
                main.showclubhomepage();
    }

    @FXML
    void bysalary(ActionEvent event) throws IOException {
            main.takeinput("salary" , playerList);
    }

    @FXML
    void clubcountryname(ActionEvent event) throws IOException {
        main.takeinput("Country Name" , playerList);
    }

    @FXML
    void countryplayercount(ActionEvent event) throws Exception {
           main.countrywiseplayercount(playerList);
    }

    @FXML
    void playername(ActionEvent event) throws Exception {
            main.takeinput("player name" , playerList);
    }

    @FXML
    void positionsearch(ActionEvent event) throws IOException {
        main.takeinput("position" , playerList);
    }

    String clubname ;
    public void ini(String name, List<Player> playerList) {
        clubname = name ;
        this.playerList  = playerList ;
        fadeeffect(byplayername);
        fadeeffect(clubcountry);
        fadeeffect(bypos);
        fadeeffect(salsearch);
        fadeeffect(countplayer);
        fadeeffect(tohome);
    }
    private void fadeeffect(Button anything)
    {
        FadeTransition fade = new FadeTransition();
        fade.setNode(anything);
        fade.setDuration(Duration.millis(2000));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }



    public void setMain(Main main) {
        this.main = main;
    }




}
