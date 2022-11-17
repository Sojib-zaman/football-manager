package Network;

import Subclass.Boughtplayerinfo;
import Subclass.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ownalert.createanalert;
import sample.*;
import util.NetworkUtil;

import java.io.IOException;
import java.util.List;

public class Buypage {
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
    List<Player>marketplayers ;
    ObservableList<Player> data =  FXCollections.observableArrayList();
    Main main ;
    Client client ;
    public void setMain(Main main, Client client)
    {
        this.client = client ;
        this.main = main ;
        setcolumn();
        System.out.println("error 0");
        try {
            marketplayers = ReadThreadClient.getmarketlist().getPlayerList();
        } catch (Exception e) {
            System.out.println(e);
        }

        if(marketplayers!=null)
       {
           for(Player p : marketplayers)
               data.add(p);
           System.out.println("error 3");
           myplayertable.setItems(data);
       }


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
        price.setCellValueFactory(new PropertyValueFactory<Player,String>("Price"));
    }

    public void  buyplayer(ActionEvent event) throws IOException
    {

        Object selectedplayer = myplayertable.getSelectionModel().getSelectedItem();
        Player selected  = (Player) selectedplayer ;


        List<Player>temp = ReadThreadClient.getmarketlist().getPlayerList();

        for(Player p:temp)
        {
            if(selected.getPlayername().equals(p.getPlayername()))
            {
                selected.isinmarket = 1 ;
                break;
            }
        }





        if(!main.clubname.equals(selected.getClubname()))
        {
            if(selected.isinmarket==1)
            {
                selected.setClubname(main.clubname);

                Boughtplayerinfo boughtplayerinfo = new Boughtplayerinfo(selected.getClubname(),main.clubname, selected) ;
                System.out.println(boughtplayerinfo);
                client.networkUtil.write(boughtplayerinfo);
            }
            else
            {
                new createanalert("This player is already taken by another club") ;
            }

        }
        else
        {
            new createanalert("This player was sold by you") ;
        }

        main.showavailableplayerstobuy(client);
        List<Player>temp2 = Server.getMarketplayerlist();
        for(Player p:temp2) System.out.println(p.getPlayername() +"............."+ p.isinmarket);



    }

    public void Backtomainmenu(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }
}
