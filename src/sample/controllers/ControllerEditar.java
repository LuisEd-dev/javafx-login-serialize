package sample.controllers;

import classes.Serializar;
import classes.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import sample.Main;


import java.io.*;
import java.security.NoSuchAlgorithmException;

public class ControllerEditar extends Controller{

    @FXML
    protected void initialize()  {
        txtEditarLogin.setText(Main.getStage().getTitle());
        btnCarregar.fire();
        //btnCarregar.setDisable(true);
    }

    @FXML
    private Button btnCarregar;

    @FXML
    private CheckBox chkCrip;


    @FXML
    void carregarDados(ActionEvent event) throws IOException {
        try {
            FileInputStream file = new FileInputStream("contas/" + txtEditarLogin.getText() + ".acc");
            ObjectInputStream object = new ObjectInputStream(file);
            Usuario conta = (Usuario) object.readObject();
            object.close();

            txtEditarSenha.setText(conta.getSenha());

        } catch (FileNotFoundException e) {
            Main.changeScreen("nao_existe");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private TextField txtEditarLogin;

    @FXML
    private PasswordField txtEditarSenha;

    @FXML
    private PasswordField txtEditarSenhaConfirma;

    @FXML
    private Label lblAviso;

    @FXML
    void editarUsuario(MouseEvent event) throws NoSuchAlgorithmException {

        if(!txtEditarLogin.getText().equals("") && !txtEditarSenha.getText().equals("") && txtEditarSenhaConfirma.getText().equals(txtEditarSenha.getText())){

            try {
                new Serializar(new Usuario(txtEditarLogin.getText(), txtEditarSenhaConfirma.getText(), chkCrip.isSelected(), "cadastrar"));
                Main.changeScreen("editado");
            } catch (FileNotFoundException e) {
                System.out.println("Falha ao criar o arquivo");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            lblAviso.setVisible(true);
        }
    }

    @FXML
    void retornarHome(MouseEvent event) throws IOException  {
        Main.changeScreen("home");
    }

}
