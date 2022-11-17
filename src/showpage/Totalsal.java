package showpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Main;

import java.io.IOException;

public class Totalsal {
    Main main  ;

    @FXML
    private Label clubname;

    @FXML
    private Label salary;
    public void setMain(Main main)
    {
        this.main = main;
    }

    public void backtomain(ActionEvent event) throws IOException {
        main.showclubhomepage();
    }
String name ;
    public void init(double salary, String validinput)
    {
        salary = salary*52.0 ;
        this.salary.setText(String.format("%.2f",salary));
        clubname.setText(validinput); name = validinput ;
    }
}
