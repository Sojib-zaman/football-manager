package showpage;

import Subclass.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;

import java.io.IOException;
import java.util.List;

public class Showplayerinfo
{
    @FXML
    private TableView myplayertable;
    @FXML
    private TableColumn<Player, String> name;

    @FXML
    private TableColumn<Player, String> country;

    @FXML
    private TableColumn<Player,Integer> age;

    @FXML
    private TableColumn<Player,Double> height;

    @FXML
    private TableColumn<Player, String> club;

    @FXML
    private TableColumn<Player, String> position;

    @FXML
    private TableColumn<Player,Integer> number;

    @FXML
    private TableColumn<Player,Double> salary;

   // @FXML
    //private TableColumn<Player,Double> price;

    @FXML
    private Button back;

    @FXML
    private Button showplayer;




    ObservableList<Player>data =  FXCollections.observableArrayList();
    Main main;
    public void setMain(Main main) {
        this.main = main;

    }
    String clubname ;

    public void ini(List<Player> players, String clubname)
    {
        this.clubname = clubname ;
        setcolumn();

        for(Player p : players)
            data.add(p);
        myplayertable.setItems(data);

    }
    public void setcolumn()
    {
        name.setCellValueFactory(new PropertyValueFactory<Player,String>("playername"));
        club.setCellValueFactory(new PropertyValueFactory<Player,String>("clubname"));
        country.setCellValueFactory(new PropertyValueFactory<Player,String>("countryname"));
        age.setCellValueFactory(new PropertyValueFactory<Player,Integer>("age"));
        height.setCellValueFactory(new PropertyValueFactory<Player,Double>("height"));
        position.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        salary.setCellValueFactory(new PropertyValueFactory<Player,Double>("weeklysalary"));
        number.setCellValueFactory(new PropertyValueFactory<Player,Integer>("number"));


    }

    public void backtomain(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }

    public void showplayer(ActionEvent event) throws Exception {
       Object selectedplayer = myplayertable.getSelectionModel().getSelectedItem();
        Player selected  = (Player) selectedplayer ;
        main.showindividualplayer(selected.getPlayername(),selected.getPosition() , data);
    }
}
