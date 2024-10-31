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

    // Creamos una instancia de Dealer (el concesionario) que se compartirá entre los controladores.
    private Dealer dealer = new Dealer();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar la ventana principal desde el archivo FXML
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("DealerView.fxml"));
        VBox mainRoot = mainLoader.load();

        // Obtener el controlador de la ventana principal y configurar el concesionario
        ConsecionarioController mainController = mainLoader.getController();
        mainController.setDealer(dealer);

        // Cargar la ventana de visualización desde el archivo FXML
        FXMLLoader displayLoader = new FXMLLoader(getClass().getResource("DisplayView.fxml"));
        VBox displayRoot = displayLoader.load();

        // Obtener el controlador de la ventana de visualización y configurarlo como observador del concesionario
        DisplayController displayController = displayLoader.getController();
        displayController.setDealer(dealer);

        // Crear una nueva ventana (Stage) para la vista del inventario y mostrarla
        Stage displayStage = new Stage();
        displayStage.setTitle("Inventario de Vehículos");
        displayStage.setScene(new Scene(displayRoot));
        displayStage.show();

        // Configurar y mostrar la ventana principal
        primaryStage.setTitle("Concesionario");
        primaryStage.setScene(new Scene(mainRoot));
        primaryStage.show();
    }


    public static void main(String[] args) {
        // Método de lanzamiento de la aplicación JavaFX
        launch(args);
    }

}
