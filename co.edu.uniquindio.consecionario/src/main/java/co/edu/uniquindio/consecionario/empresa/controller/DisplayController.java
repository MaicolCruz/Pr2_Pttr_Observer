package co.edu.uniquindio.consecionario.empresa.controller;

import co.edu.uniquindio.consecionario.empresa.Model.Dealer;
import co.edu.uniquindio.consecionario.empresa.Service.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class DisplayController implements Observer {
    private Dealer dealer;

    @FXML
    private ListView<String> inventoryList;

    @FXML
    private TextField vehicleField;

    private ObservableList<String> inventoryObservable = FXCollections.observableArrayList();

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
        if (this.dealer != null) {
            this.dealer.addObserver(this);
            update();
        }
    }
    @Override
    public void update() {
        if (dealer != null) {
            inventoryObservable.clear();
            inventoryObservable.addAll(dealer.getInventory());
            inventoryList.setItems(inventoryObservable);
        }
    }
}
