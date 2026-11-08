package co.edu.uniquindio.parcial3.parcial3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial3.parcial3.modelo.Dispositivo;
import co.edu.uniquindio.parcial3.parcial3.modelo.Habitacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class InicioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea TxtEventos;

    @FXML
    private Button btnCerraduras;

    @FXML
    private Button btnLuces;

    @FXML
    private Button btnSensores;

    @FXML
    private Button btnTermostatos;

    @FXML
    private ListView<Dispositivo> listViewDispositivos;

    @FXML
    private ListView<Habitacion> listViewHabitaciones;

    @FXML
    void onActionCerraduras(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/parcial3/parcial3/cerraduras.fxml")
            );

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle("Gestión de Cerraduras");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionLuces(ActionEvent event) {

    }

    @FXML
    void onActionSensores(ActionEvent event) {

    }

    @FXML
    void onActionTermostatos(ActionEvent event) {

    }

    @FXML
    void initialize() {
        Habitacion sala = new Habitacion("Sala");
        Habitacion cocina = new Habitacion("Cocina");

        listViewHabitaciones.getItems().addAll(
                sala,
                cocina
        );

    }

}
