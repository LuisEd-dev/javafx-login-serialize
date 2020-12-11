package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private static Scene loginScene;
    private static Scene homeScene;
    private static Scene erroScene;
    private static Scene naoExisteScene;
    private static Scene vazioScene;
    private static Scene sucessoScene;
    private static Scene excluidoScene;
    private static Scene editarScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("TELA INICIAL");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("telas/login.fxml"));
        loginScene = new Scene(fxmlLogin);

        Parent fxmlHome = FXMLLoader.load(getClass().getResource("telas/home.fxml"));
        homeScene = new Scene(fxmlHome);

        Parent fxmlErro = FXMLLoader.load(getClass().getResource("telas/erro.fxml"));
        erroScene = new Scene(fxmlErro);

        Parent fxmlNaoExiste = FXMLLoader.load(getClass().getResource("telas/naoExiste.fxml"));
        naoExisteScene = new Scene(fxmlNaoExiste);

        Parent fxmlPreencher = FXMLLoader.load(getClass().getResource("telas/preencher.fxml"));
        vazioScene = new Scene(fxmlPreencher);

        Parent fxmlSucesso = FXMLLoader.load(getClass().getResource("telas/sucesso.fxml"));
        sucessoScene = new Scene(fxmlSucesso);

        Parent fxmlExcluido = FXMLLoader.load(getClass().getResource("telas/excluido.fxml"));
        excluidoScene = new Scene(fxmlExcluido);

        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScreen(String tela) throws IOException {

        switch (tela){
            case "login":
                stage.setScene(loginScene);
                stage.setTitle("LOGIN");
                break;
            case "home":
                stage.setScene(homeScene);
                stage.setTitle("HOME");
                break;
            case "erro":
                stage.setScene(erroScene);
                stage.setTitle("ERRO");
                break;
            case "nao_existe":
                stage.setScene(naoExisteScene);
                stage.setTitle("NAO EXISTE");
                break;
            case "vazio":
                stage.setScene(vazioScene);
                stage.setTitle("PREENCHA");
                break;
            case "sucesso":
                stage.setScene(sucessoScene);
                stage.setTitle("CADASTRADO");
                break;
            case "excluido":
                stage.setScene(excluidoScene);
                stage.setTitle("EXCLUIDO");
                break;
            case "editar":
                Parent fxmlEditar = FXMLLoader.load(Main.class.getResource("telas/editar.fxml"));
                editarScene = new Scene(fxmlEditar);

                stage.setScene(editarScene);
                stage.setTitle("EDITAR");
                break;
        }
    }

    public static Stage getStage() {
        return stage;
    }

}

