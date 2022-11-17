package sample;

import InputPage.Inputtaker;
import InputPage.Mulinputtaker;
import Network.Buypage;
import Network.Cellpage;
import Network.Client;
import Network.Transferhome;
import Search.Clubsearcher;
import Search.Playersearchcontrol;
import Search.Searchbyclubcontrol;
import Subclass.Countrywiseplayer;
import Subclass.Player;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ownalert.Createalert;
import showpage.Individualplayer;
import showpage.Showplayerinfo;
import showpage.Totalsal;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {
    Stage stage;
    MediaPlayer song;
     public String clubname ;
    Client client ;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        showloginpage();
        
    }
    public static void main(String[] args)
    {
        launch(args);
    }

    public void showloginpage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller ctrl = loader.getController();
        ctrl.setMain(this);
        Scene scene = new Scene(root , 600 , 375) ;
        String css = this.getClass().getResource("logincss.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }



    public void createanalert() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ownalert/createalert.fxml"));
        Parent root = loader.load();

        Createalert ctrl = loader.getController();
        ctrl.setMain(this);

        stage.setTitle("Alert");
        stage.setScene(new Scene(root , 480 , 190));
        stage.setResizable(true);
        stage.show();
    }

    Boolean musicstarted = false ;
    public void showclubhomepage(String username, Client client) throws IOException
    {
        this.client = client;
        if(!musicstarted)
        {
            music();
            musicstarted=true;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clubhomepage.fxml"));
        Parent root = loader.load();

        this.client = client ;
        Clubhomepage ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(username,client) ;
        ctrl.ini();
        clubname = username ;
        stage.setTitle("Club Home Page");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();

    }
    public void searchbyplayermenu(String clubname, List<Player> playerList) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Search/playersearch.fxml"));
        Parent root = loader.load();
        Playersearchcontrol ctrl = loader.getController();
        //List<Player> playerList = fileoperations.readFromFile();
        ctrl.ini(this.clubname , playerList);
        ctrl.setMain(this);

        stage.setTitle("Player Search Window");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();
    }
    public void searchbyclubmenu(String clubname, List<Player> playerList)throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Search/searchbyclub.fxml"));
        Parent root = loader.load();

        Searchbyclubcontrol ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(clubname,playerList);


        stage.setTitle("club window ");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();

    }


    public void takeinput(String required , List<Player>playerList) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root ;
        if(required.equals("salary"))
        {
            loader.setLocation(getClass().getResource("/InputPage/mulinputtaker.fxml"));
            root = loader.load();
            Mulinputtaker ctrl = loader.getController();
            ctrl.setMain(this);

            ctrl.init(required,playerList);

        }
        else
        {
            loader.setLocation(getClass().getResource("/InputPage/inputtaker.fxml"));
            root = loader.load();
            Inputtaker ctrl = loader.getController();
            ctrl.setMain(this);
            ctrl.init(required,playerList);

        }

        stage.setTitle("Input window ");
        stage.setScene(new Scene(root , 760 , 500));
        stage.setResizable(true);
        stage.show();


    }
    public void showindividualplayer(String selectedPlayername, String playerpos, ObservableList<Player> data) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/showpage/individualplayer.fxml"));
        Parent root = loader.load();

        Individualplayer ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(selectedPlayername,playerpos,data);
        Scene scene = new Scene(root , 400 , 400) ;
        String css = this.getClass().getResource("/showpage/indi.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Individual player ");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    public void countrywiseplayercount(List<Player> playerList) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Subclass/countrywiseplayer.fxml"));
        Parent root = loader.load();

        Countrywiseplayer ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(clubname,playerList);
        stage.setTitle("Country wise");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();
    }
    private void music()
    {

        Media name  = new Media(Paths.get("intro.mp3").toUri().toString());
        song = new MediaPlayer(name);
        song.play();


    }
    public void showtotalsalary(double salary, String validinput) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/showpage/totalsal.fxml"));
        Parent root = loader.load();

        Totalsal ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(salary,validinput);
        stage.setTitle("Total Salary for clubs");
        stage.setScene(new Scene(root , 700 , 450));
        stage.setResizable(true);
        stage.show();
    }
    public void showplayer(List<Player> players) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/showpage/showplayerinfo.fxml"));
        Parent root = loader.load();

        Showplayerinfo ctrl = loader.getController();
        ctrl.ini(players , clubname);

        ctrl.setMain(this);
        Scene scene = new Scene(root , 800 , 600) ;
        String css = this.getClass().getResource("/showpage/showplayerlist.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Player info");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void clubsearchproperty(String s, List<Player> playerList) throws Exception
    {


        List<Player> players;

        switch (s)
        {

            case "Maximum Age Player of The Club : ":
            {


                players=new Clubsearcher(playerList).searchmaxage(clubname);
                showplayer(players);
                break;
            }
            case "Maximum Height Player of The Club : ":
            {
                players=new Clubsearcher(playerList).searchmaxheight(clubname);
                showplayer(players);
                break;
            }
            case "Maximum Salary Player of The Club : ":
            {
                players=new Clubsearcher(playerList).searchmaxsalary(clubname);
                showplayer(players);
                break;
            }
            case "Total Salary of The Club : ":
            {
                double sal  = new Clubsearcher(playerList).totalsalary(clubname);
                showtotalsalary(sal,clubname);
                break;
            }
        }
    }

    public void transfermarket(Client client) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Network/transferhome.fxml"));
        Parent root = loader.load();

        Transferhome ctrl = loader.getController();
        ctrl.setMain(this);
        ctrl.init(clubname , client) ;
        Scene scene = new Scene(root , 600 , 400) ;
        //String css = this.getClass().getResource("transfer.css").toExternalForm();
        scene.getStylesheets().add("/Network/transfer.css");

        stage.setTitle("Transfer window");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void showavailableplayerstobuy(Client client) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Network/buypage.fxml"));
        Parent root = loader.load();
        Buypage ctrl = loader.getController();
        ctrl.setMain(this , client);
        stage.setTitle("Available players ");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();
    }

    public void showclubhomepage() throws IOException {
        String name = clubname ;
        showclubhomepage(name, client);
    }

    public void showplayerstosell(Client client) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Network/cellpage.fxml"));
        Parent root = loader.load();
        Cellpage ctrl = loader.getController();
        ctrl.setMain(this,client);
        stage.setTitle("Players to be sold ");
        stage.setScene(new Scene(root , 800 , 600));
        stage.setResizable(true);
        stage.show();
    }
}
