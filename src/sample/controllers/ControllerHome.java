package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.File;
import java.io.IOException;

public class ControllerHome extends Controller {

    private ObservableList itens = FXCollections.observableArrayList();

    @FXML
    private ComboBox<?> combo;

    @FXML
    void carregarUsuarios(MouseEvent event) {

        combo.getItems().clear();
        itens.removeAll();

        File[] arquivos = new File("contas/").listFiles();

        for (File arquivo : arquivos) {
            itens.add(arquivo.getName().split(".acc")[0]);
        }

        combo.setItems(itens);
    }

    @FXML
    void deleteUsuario(MouseEvent event) throws IOException {
        File usuario = new File("contas/" + combo.valueProperty().get() + ".acc");
        if(usuario.delete())
            Main.changeScreen("excluido");
    }

    @FXML
    void editeUsuario(MouseEvent event) throws IOException {

        if(combo.valueProperty().get() != null){
            Main.getStage().setTitle(String.valueOf(combo.valueProperty().get()));
            Main.changeScreen("editar");
        } else {
            Main.changeScreen("escolherUsuario");
        }

    }

}
