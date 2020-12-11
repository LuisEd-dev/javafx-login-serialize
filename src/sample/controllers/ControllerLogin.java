package sample.controllers;

import classes.MD5;
import classes.Serializar;
import classes.Usuario;
import classes.Verificar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class ControllerLogin extends Controller {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabLogin;

    @FXML
    private TextField txtLoginUser;

    @FXML
    private PasswordField txtLoginSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private Tab tabCadastro;

    @FXML
    private TextField txtCadastroLogin;

    @FXML
    private PasswordField txtCadastroSenha;

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox chkCrip;

    @FXML
    void cadastrar(MouseEvent event) throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
        if(!txtCadastroLogin.getText().equals("") && !txtCadastroSenha.getText().equals("")){

            Usuario usuario = new Usuario(txtCadastroLogin.getText(), txtCadastroSenha.getText(), chkCrip.isSelected(), "cadastrar");

            if(new Verificar().Verificar(usuario)){
                try {
                    new Serializar(usuario);
                    tabPane.getSelectionModel().select(tabLogin);
                    Main.changeScreen("sucesso");
                } catch (FileNotFoundException e) {
                    System.out.println("Falha ao criar o arquivo");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Main.changeScreen("usuarioRepetido");
            }

        } else {
            Main.changeScreen("vazio");
        }
    }

    @FXML
    void logar(MouseEvent event) throws NoSuchAlgorithmException, IOException {

        if(!txtLoginUser.getText().equals("") && !txtLoginSenha.getText().equals("")) {

            try {
                FileInputStream file = new FileInputStream("contas/" + txtLoginUser.getText() + ".acc");
                ObjectInputStream object = new ObjectInputStream(file);
                Usuario conta = (Usuario) object.readObject();
                object.close();

                if(conta.getLogin().equals(txtLoginUser.getText()) &&
                        (conta.getSenha().equals(txtLoginSenha.getText()) || conta.getSenha().equals(new MD5(String.valueOf(txtLoginSenha.getText())).getHash())) ){
                    Main.changeScreen("home");
                } else {
                    Main.changeScreen("erro");
                }
            } catch (FileNotFoundException e) {
                Main.changeScreen("nao_existe");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            Main.changeScreen("vazio");
        }
    }

}
