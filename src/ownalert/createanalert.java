package ownalert;

import javafx.scene.control.Alert;

public class createanalert {
    public createanalert(String s)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Inappropriate transfer");
        alert.setHeaderText("This operation can not be performed");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
