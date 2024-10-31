module co.edu.uniquindio.consecionario.empresa {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.consecionario.empresa to javafx.fxml;
    opens co.edu.uniquindio.consecionario.empresa.controller;
    exports co.edu.uniquindio.consecionario.empresa.controller;
    opens co.edu.uniquindio.consecionario.empresa.viewController;
    exports co.edu.uniquindio.consecionario.empresa.viewController;
    exports co.edu.uniquindio.consecionario.empresa;
}