// Contrôleur principal de l'interface graphique
package com.solucar.infrastructure.ui;

import com.solucar.application.CarDataService;
import com.solucar.infrastructure.obd.OBDAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class MainController {
    
    public void connectToOBD() {
        try {
            obdAdapter.connect();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
