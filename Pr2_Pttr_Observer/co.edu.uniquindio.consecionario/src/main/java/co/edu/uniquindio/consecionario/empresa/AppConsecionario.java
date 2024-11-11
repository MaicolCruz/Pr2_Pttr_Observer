package co.edu.uniquindio.consecionario.empresa;

import co.edu.uniquindio.consecionario.empresa.Model.Dealer;
import co.edu.uniquindio.consecionario.empresa.controller.ConsecionarioController;
import co.edu.uniquindio.consecionario.empresa.controller.DisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AppConsecionario extends Application {
    private Dealer dealer = new Dealer();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar la ventana principal del cliente
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("DealerView.fxml"));
        VBox mainRoot = mainLoader.load();
        ConsecionarioController mainController = mainLoader.getController();
        mainController.setDealer(dealer);
        primaryStage.setTitle("Concesionario");
        primaryStage.setScene(new Scene(mainRoot, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();

        // Cargar la ventana de visualización del Empleado
        FXMLLoader displayLoader = new FXMLLoader(getClass().getResource("DisplayView.fxml"));
        VBox displayRoot = displayLoader.load();
        DisplayController displayController = displayLoader.getController();
        displayController.setDealer(dealer);
        Stage displayStage = new Stage();
        displayStage.setTitle("Inventario de Vehículos");
        displayStage.setScene(new Scene(displayRoot, 600, 400));
        displayStage.setResizable(false);
        displayStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
