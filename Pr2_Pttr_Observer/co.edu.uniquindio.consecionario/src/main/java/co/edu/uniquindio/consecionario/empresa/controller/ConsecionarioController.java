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
            System.out.println("Vehículo añadido: " + vehicle);
        } else {
            System.out.println("El campo de vehículo está vacío.");
        }
    }

    @FXML
    private void handleSellVehicle() {
        String vehicle = vehicleField.getText();
        if (!vehicle.isEmpty()) {
            boolean sold = dealer.sellVehicle(vehicle);
            vehicleField.clear();
            if (sold) {
                System.out.println("Vehículo vendido: " + vehicle);
            } else {
                System.out.println("El vehículo no se encontró en el inventario: " + vehicle);
            }
        } else {
            System.out.println("El campo de vehículo está vacío.");
        }
    }
}
