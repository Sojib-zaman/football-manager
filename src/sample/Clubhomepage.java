package sample;

import Network.Client;
import Network.ReadThreadClient;
import Subclass.Player;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import util.NetworkUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;

public class Clubhomepage
{

    List<Player> playerList;
    public ImageView footballimg1;
    NetworkUtil networkUtil ;
    Main main;
    Client client ;
    String clubname;

    public static void setDeleted(Player deleted) {
        Clubhomepage.deleted = deleted;
    }

    static Player deleted ;

    public static void setNewcomer(Player newcomer) {
        Clubhomepage.newcomer = newcomer;
    }

    static Player newcomer ;




    public void ini()
    {
        Image image = new Image(new File("img/lilkid.gif").toURI().toString());
        footballimg1.setImage(image);
        playerList = ReadThreadClient.getlist().getPlayerList();
        //playerList.clear();
        playerList.remove(deleted);

       // for(Player p: playerList) System.out.println("IN PLAYERLIST : "+ p.getPlayername());
       // if(playerList==null) System.out.println("null");
    }

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private Button playersearch;
    @FXML
    private Label cname;
    @FXML
    private ImageView cimg;
    @FXML
    private Button clubsearch;
    @FXML
    private Button playeradd;
    @FXML
    private Button exit;
    Boolean clientbased = false;
    public void searchbyplayer(ActionEvent event) throws Exception {
        main.searchbyplayermenu(clubname , playerList);
    }

    public void searchbyclub(ActionEvent event) throws Exception {
        main.searchbyclubmenu(clubname , playerList);
    }
    public void Makertwindow(ActionEvent event) throws IOException {
        main.transfermarket(client);

    }
    public void exitsystem(ActionEvent event) throws InterruptedException {
        exit(0);
    }



    public void init(String username, Client client)
    {
        this.client = client ;

        clubname = username;
        cname.setText(clubname);
        Image image = new Image(new File("img/"+clubname.toLowerCase()+".png").toURI().toString());
        cimg.setImage(image);
        cimg.setLayoutX(0); cimg.setLayoutY(0);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(271);transition.setToY(93);transition.setNode(cimg);transition.play();

    }



}