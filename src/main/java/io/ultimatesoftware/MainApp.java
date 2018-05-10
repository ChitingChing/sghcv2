package io.ultimatesoftware;

import io.ultimatesoftware.sghc.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class MainApp extends Application {
    
    /*public HiddenSidesPane hsp = new HiddenSidesPane();

    public HiddenSidesPane getHsp() {
        return hsp;
    }

    public void setHsp(HiddenSidesPane hsp) {
        this.hsp = hsp;
    }
    
    */

    @Override
    public void start(Stage stage) throws Exception {
        showHome();
    }
    private void showHome()
    {
        try {
            Connection c = new Connection();
           // HiddenSidesPane hsp = new HiddenSidesPane();
            Stage stage = new Stage();

            //hsp.setMinSize(Double.MAX_VALUE, Double.MAX_VALUE);


            VBox VBHome = null;

            VBHome = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
            Scene scene = new Scene(VBHome);
            scene.getStylesheets().add("/styles/SidePane.css");
            scene.getStylesheets().add("/styles/Styles.css");
            //hsp.setContent(VBHome);
            //VBox vbSidePane = FXMLLoader.load(getClass().getResource("/fxml/SidePane.fxml"));
            //hsp.setLeft(vbSidePane);

          stage.setMaximized(true);
            stage.setTitle("Sistema de Gestión Clínica");
            stage.setScene(scene);
        //  stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
