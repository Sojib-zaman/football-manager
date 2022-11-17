package Network;

import InputPage.Pricebox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Main;
import Subclass.Player;
import Subclass.Soldplayerinfo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Cellpage {
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

    @FXML
    private TableColumn<Player, String > price;

    Client client ;
    ObservableList<Player> data =  FXCollections.observableArrayList();
    Main main ;
    Stage pricestage = new Stage();
    String inputprice;



    public void setMain(Main main, Client client) {
        this.main = main ;
        this.client = client ;

        setcolumn();
        List<Player> list = ReadThreadClient.getlist().getPlayerList(); //got to be changed
        for(Player p : list)
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

    public void sellplayer(ActionEvent event) throws IOException {
        Object selectedplayer = myplayertable.getSelectionModel().getSelectedItem();
        Player selected  = (Player) selectedplayer ;

        try {
            pricetaker(selected.getPlayername() , selected.getWeeklysalary());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
       selected.setPrice(inputprice);

        Soldplayerinfo soldplayerinfo = new Soldplayerinfo(main.clubname, selected) ;
        System.out.println(soldplayerinfo);
        client.networkUtil.write(soldplayerinfo);
        main.showplayerstosell(client) ;
    }

    private void pricetaker(String player , double sal) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/InputPage/Pricebox.fxml"));
        Parent root = loader.load();
        Pricebox ctrl = loader.getController();
        ctrl.init(player,sal);
        Scene scene = new Scene(root , 600 , 375) ;

        pricestage.setTitle("Main menu");
        pricestage.setScene(scene);
        pricestage.setResizable(true);
        pricestage.showAndWait();
        System.out.println(ctrl.getsal());
        if(ctrl.getsal()!=0)
        {
            System.out.println("INSIDE");

            inputprice = String.valueOf(ctrl.getsal());
            pricestage.close();
        }


    }
}
