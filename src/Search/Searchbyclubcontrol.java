package Search;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;
import Subclass.Player;

import java.io.IOException;
import java.util.List;

public class Searchbyclubcontrol {
    Main main ;
    List<Player>playerList ;
    @FXML
    private Button maxsalary;
    public void setMain(Main main)
    {
        this.main=main;
    }
    @FXML
    private Button maxage;

    @FXML
    private Button maxheight;

    @FXML
    private Button total;

    @FXML
    private Button back;

    @FXML
    void backtomain(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }

    @FXML
    void clickedonmaxage(ActionEvent event) throws Exception {
        main.clubsearchproperty("Maximum Age Player of The Club : ", playerList);
    }

    @FXML
    void clickedonmaxheight(ActionEvent event) throws Exception {
        main.clubsearchproperty("Maximum Height Player of The Club : " , playerList);
    }

    @FXML
    void clickedonmaxsalary(ActionEvent event) throws Exception {
        main.clubsearchproperty("Maximum Salary Player of The Club : " , playerList);
    }

    @FXML
    void clickedontotalsalary(ActionEvent event) throws Exception {
        main.clubsearchproperty("Total Salary of The Club : " , playerList);
    }
    String clubname ;
    public void init(String clubname, List<Player> playerList) {
        this.clubname = clubname ;
        this.playerList  = playerList ;
    }
}
