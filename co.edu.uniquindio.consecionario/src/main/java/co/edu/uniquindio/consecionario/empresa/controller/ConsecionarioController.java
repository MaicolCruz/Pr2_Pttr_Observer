package co.edu.uniquindio.consecionario.empresa.controller;

import co.edu.uniquindio.consecionario.empresa.Model.Dealer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConsecionarioController {
    private Dealer dealer;

    @FXML
    private TextField vehicleField;

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @FXML
    private void handleAddVehicle() {
        String vehicle = vehicleField.getText();
        if (!vehicle.isEmpty()) {
            dealer.addVehicle(vehicle);
            vehicleField.clear();
        }
    }

    @FXML
    private void handleSellVehicle() {
        String vehicle = vehicleField.getText();
        if (!vehicle.isEmpty()) {
            dealer.sellVehicle(vehicle);
            vehicleField.clear();
        }
    }
}
