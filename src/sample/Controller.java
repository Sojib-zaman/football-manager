package sample;

import Network.Client;
import Network.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.NetworkUtil;

import java.io.IOException;
import java.util.HashMap;

public class Controller {
    Main main  ;
    @FXML
    private TextField clubname;
    @FXML
    private Button loginbutton;
    @FXML
    private PasswordField password;
    Client client ;String username ;
    boolean valid = false ;
    String[] clubs = {"Arsenal","Liverpool","Manchester United","Chelsea","Manchester City"};
    @FXML
    void login(ActionEvent event) throws IOException {
         username= clubname.getText() ;
        Boolean clientbased = false ;
        String pass = password.getText();

        for(String s:clubs)
        {


            if(s.equals(username) && pass.equals(username+"108"))
                valid  = true ;
        }
        if(valid) {




            client = new Client(username);

            main.showclubhomepage(username,client);

        } else
            main.createanalert();

    }
    public void setMain(Main main) {
        this.main = main ;
    }
    public Client getClient(){return client ; }
}
