package io.ultimatesoftware.sghc;


import javafx.scene.control.Alert;

public class Message {

    public Message() {
    }

    public void showMessage(String header, String message, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }


}
