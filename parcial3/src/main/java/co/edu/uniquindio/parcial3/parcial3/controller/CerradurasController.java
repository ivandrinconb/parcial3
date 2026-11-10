package co.edu.uniquindio.parcial3.parcial3.controller;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.parcial3.parcial3.Command.BloquearCerraduraCommand;
import co.edu.uniquindio.parcial3.parcial3.Command.CommandHistorial;
import co.edu.uniquindio.parcial3.parcial3.Command.DesbloquearCerraduraCommand;
import co.edu.uniquindio.parcial3.parcial3.Command.ReiniciarCerraduraCommand;
import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class CerradurasController {

    private CommandHistorial historial;

    private Cerradura cerraduraSeleccionada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBloquear;

    @FXML
    private Button btnDesbloquear;

    @FXML
    private Button btnDeshacer;

    @FXML
    private Button btnRehacer;

    @FXML
    private Button btnReiniciar;

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblIntentos;

    @FXML
    private Label lblMaxIntentos;

    @FXML
    private Label lblNombre;

    @FXML
    private ListView<Cerradura> listViewCerraduras;

    @FXML
    private PasswordField txtPin;

    @FXML
    private TextArea txtHistorial;

    @FXML
    void onActionBloquear(ActionEvent event) {
        if (cerraduraSeleccionada == null) {
            return;
        }

        BloquearCerraduraCommand comando =
                new BloquearCerraduraCommand(
                        cerraduraSeleccionada
                );

        historial.ejecutar(comando);

        actualizarInformacion();

        actualizarHistorial();
    }

    @FXML
    void onActionDesbloquear(ActionEvent event) {
        if (cerraduraSeleccionada == null) {
            return;
        }

        String pin = txtPin.getText();

        DesbloquearCerraduraCommand comando =
                new DesbloquearCerraduraCommand(
                        cerraduraSeleccionada,
                        pin
                );

        historial.ejecutar(comando);

        actualizarInformacion();

        actualizarHistorial();

        txtPin.clear();
    }

    @FXML
    void onActionDeshacer(ActionEvent event) {
        historial.deshacer();

        actualizarInformacion();

        actualizarHistorial();
    }

    @FXML
    void onActionRehacer(ActionEvent event) {
        historial.rehacer();

        actualizarInformacion();

        actualizarHistorial();
    }

    @FXML
    void onActionReiniciar(ActionEvent event) {
        if (cerraduraSeleccionada == null) {
            return;
        }

        ReiniciarCerraduraCommand comando =
                new ReiniciarCerraduraCommand(
                        cerraduraSeleccionada
                );

        historial.ejecutar(comando);

        actualizarInformacion();

        actualizarHistorial();
    }

    @FXML
    void initialize() {

        historial = new CommandHistorial();
        txtHistorial.setEditable(false);

        // Crear cerraduras de prueba por defecto
        Cerradura principal =
                new Cerradura(
                        "Cerradura Principal",
                        "1234",
                        3
                );

        Cerradura garaje =
                new Cerradura(
                        "Puerta Garaje",
                        "5678",
                        3
                );

        // Agregarlas al ListView
        listViewCerraduras.getItems().addAll(
                principal,
                garaje
        );

        // Escuchar selección de cerraduras en la interfaz
        listViewCerraduras.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionada) -> {

                    if (seleccionada != null) {
                        this.cerraduraSeleccionada = seleccionada;
                        actualizarInformacion();
                    }

                });
    }

    private void actualizarInformacion() {

        if (cerraduraSeleccionada == null) {
            return;
        }

        lblNombre.setText(
                cerraduraSeleccionada.getNombre()
        );

        lblEstado.setText(
                cerraduraSeleccionada.getDescripcionEstado()
        );

        lblIntentos.setText(
                String.valueOf(
                        cerraduraSeleccionada.getIntentosFallidos()
                )
        );

        lblMaxIntentos.setText(
                String.valueOf(
                        cerraduraSeleccionada.getMaxIntentos()
                )
        );
    }

    private void actualizarHistorial() {

        txtHistorial.clear();

        for (String registro : historial.getRegistro()) {

            txtHistorial.appendText(
                    registro + "\n"
            );

        }
    }
}

