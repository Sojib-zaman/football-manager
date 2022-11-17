package InputPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Pricebox {
    @FXML
    private Label playername;

    @FXML
    private TextField playerprice;

    @FXML
    private Label Salary;
    String inputsalary = "0" ;

    public void init(String player, double sal)
    {
        playername.setText(player);
        Salary.setText(String.valueOf(sal));

    }
    @FXML
    void submit(ActionEvent event)
    {

            inputsalary  = playerprice.getText();
            System.out.println(inputsalary);

    }
    public int getsal()
    {

        return Integer.parseInt(inputsalary) ;

    }

}
