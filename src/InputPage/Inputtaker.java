package InputPage;

import Search.playersearcher;
import Subclass.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Inputtaker {
    List<Player>playerList ;
    public ImageView imageview;
    String orderer;
    String validinput="" ;
    @FXML
    private TextField userinput;
    @FXML
    private Button submitinput;
    @FXML
     private Label requirement ;
    @FXML
    private Button resetinput;

    Main main ;
    public void setMain(Main main) {
        this.main = main ;
    }

    public void submitinput(ActionEvent event) throws Exception
    {
        validinput=userinput.getText().trim();
        List<Player> players;

        switch (orderer)
        {
            case "player name":
            {
                players =new playersearcher(playerList).searchbyname(validinput);
                main.showplayer(players);
                break;
            }
            case "Country Name":
            {
                players =new  playersearcher(playerList).clubcountryplayer(validinput);
                main.showplayer(players);
                break;
            }

            case "position":
            {
                players =new  playersearcher(playerList).searchbypos(validinput);
                main.showplayer(players);
                break;
            }
        }


    }
    public String getString()
    {
        return validinput;
    }
    String clubname ;
    public void init(String s,List<Player>playerList)
    {
        requirement.setText(s.toUpperCase());
        orderer=s;
        Image image = new Image(new File("img/manyplayer.gif").toURI().toString());
        imageview.setImage(image);
        this.clubname = clubname ;
        this.playerList = playerList ;

    }


    public void resetinp(ActionEvent event)
    {
        userinput.setText("");
    }

    public void backtohome(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }
}
