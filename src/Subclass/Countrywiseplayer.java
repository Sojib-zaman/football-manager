package Subclass;

import Search.playersearcher;
import Subclass.Country;
import Subclass.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Countrywiseplayer {
    @FXML
    private ImageView bgimg;
    Main main ;
    @FXML
    private TableView playertable;

    int playercountpercountry ;
    @FXML
    private TableColumn<Country, String> countryname;

    @FXML
    private TableColumn<Country,Integer> playercount;

    ObservableList<Country> countrylist = FXCollections.observableArrayList();
    int[] countrywiseplayers;
    String name ;
    public void setMain(Main main) {
        this.main = main ;
    }
    public void init(String clubname, List<Player> playerList) throws Exception
    {

        Image image = new Image(new File("img/bgg.jpg").toURI().toString());
        name  = clubname ;
        bgimg.setImage(image);


        List<Country>countrylist1  = new playersearcher(playerList).getCountrylist();
        for(Country c: countrylist1)
        {
            c.setPlayercount(playerList);
            countrylist.add(c);
        }
        playertable.setItems(countrylist);
        setcolumn();



    }
    public void setcolumn() {
        countryname.setCellValueFactory(new PropertyValueFactory<Country, String>("countryname"));
        playercount.setCellValueFactory(new PropertyValueFactory<Country, Integer>("playercount"));
    }

    public void backtomain(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }
}
