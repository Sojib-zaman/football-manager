package ownalert;

import javafx.event.ActionEvent;
import sample.Main;

import java.io.IOException;

public class Createalert
{
    Main main ;
    public void setMain(Main main) {
        this.main = main ;
    }

    public void backtologin(ActionEvent event) throws IOException {
        main.showloginpage();
    }
}
