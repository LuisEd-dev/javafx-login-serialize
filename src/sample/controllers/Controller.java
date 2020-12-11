package sample.controllers;

import classes.MD5;
import classes.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.*;

public class Controller {

    @FXML
    void retornarLogin(MouseEvent event) throws IOException {
        Main.changeScreen("login");
    }
    @FXML
    void retornarHome(MouseEvent event) throws IOException {
        Main.changeScreen("home");
    }


}
