package sample;

import classes.MD5;
import classes.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Controller implements Serializable{

    @FXML
    private Tab tabLogin;

    @FXML
    private TextField txtLoginUser;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtLoginSenha;

    @FXML
    private Tab tabCadastro;

    @FXML
    private TextField txtCadastroLogin;

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox chkCrip;

    @FXML
    private PasswordField txtCadastroSenha;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextArea txtUsuarios;

    @FXML
    void cadastrar(MouseEvent event) throws NoSuchAlgorithmException {
        if(!txtCadastroLogin.getText().equals("") && !txtCadastroSenha.getText().equals("")){
            Usuario cadastro = new Usuario(txtCadastroLogin.getText(), txtCadastroSenha.getText(), chkCrip.isSelected(), "cadastrar");

            try {
                FileOutputStream file = new FileOutputStream("contas/" + cadastro.getLogin() + ".acc");
                ObjectOutputStream object = new ObjectOutputStream(file);
                object.writeObject(cadastro);

                object.close();
                tabPane.getSelectionModel().select(tabLogin);
                Main.changeScreen("sucesso");

            } catch (FileNotFoundException e) {
                System.out.println("Falha ao criar o arquivo");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Main.changeScreen("vazio");
        }
    }

    @FXML
    void logar(MouseEvent event) throws NoSuchAlgorithmException{

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
                Main.changeScreen("erro");
                System.out.println("Usuario não existe!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            Main.changeScreen("vazio");
        }
    }
    @FXML
    void retornarLogin(MouseEvent event) {
        Main.changeScreen("login");
    }
    @FXML
    void carregarUsuarios(MouseEvent event) {
        File[] arquivos = new File("contas/").listFiles();

        for (File arquivo : arquivos) {
            txtUsuarios.appendText(arquivo.getName() + "\n");
        }
    }

}