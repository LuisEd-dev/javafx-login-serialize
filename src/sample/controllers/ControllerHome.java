package sample.controllers;

import classes.Deserializar;
import classes.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import sample.Main;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControllerHome extends Controller {

    private ObservableList itens = FXCollections.observableArrayList();

    @FXML
    private ComboBox<?> combo;

    @FXML
    void carregarUsuarios(MouseEvent event) throws IOException, ClassNotFoundException {

        combo.getItems().clear();
        itens.removeAll();

        new Deserializar().Deserializar().forEach(conta -> { itens.add(conta.getLogin()); });

        combo.setItems(itens);
    }

    @FXML
    void deleteUsuario(MouseEvent event) throws IOException, ClassNotFoundException {

        ArrayList lista = new ArrayList();
        Usuario delete = null;

        for(Usuario usuario : new Deserializar().Deserializar()){
            if(combo.valueProperty().get().equals(usuario.getLogin())){
                delete = usuario;
            }
            lista.add(usuario);
        }

        lista.remove(delete);

        FileOutputStream file = new FileOutputStream("contas/contas.acc");
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(lista);
        object.close();

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
