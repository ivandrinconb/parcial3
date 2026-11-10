package co.edu.uniquindio.parcial3.parcial3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;
import co.edu.uniquindio.parcial3.parcial3.modelo.Dispositivo;
import co.edu.uniquindio.parcial3.parcial3.modelo.Habitacion;
import co.edu.uniquindio.parcial3.parcial3.modelo.Luz;
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
    void onActionLuces(ActionEvent event) {}

    @FXML
    void onActionSensores(ActionEvent event) {}

    @FXML
    void onActionTermostatos(ActionEvent event) {}

    @FXML
    void initialize() {
        // 1. Crear dispositivos pasando el nombre por parámetro al constructor
        Luz luzSala = new Luz("Luz Sala");
        Cerradura cerraduraPrincipal = new Cerradura("Cerradura Principal", "1234", 3);
        Luz luzCocina = new Luz("Luz Cocina");

        // 2. Crear las habitaciones pasando el nombre por parámetro
        Habitacion sala = new Habitacion("Sala");
        sala.getDispositivos().add(luzSala);
        sala.getDispositivos().add(cerraduraPrincipal);

        Habitacion cocina = new Habitacion("Cocina");
        cocina.getDispositivos().add(luzCocina);

        // 3. Agregar habitaciones al ListView principal
        listViewHabitaciones.getItems().addAll(
                sala,
                cocina
        );

        // 4. Escuchar la selección de habitaciones
        listViewHabitaciones.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, habitacionSeleccionada) -> {
                    if (habitacionSeleccionada != null) {
                        listViewDispositivos.getItems().setAll(
                                habitacionSeleccionada.getDispositivos()
                        );
                    }
                });
    }
}