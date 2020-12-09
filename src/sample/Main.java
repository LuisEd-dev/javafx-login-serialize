package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;
    private static Scene loginScene;
    private static Scene homeScene;
    private static Scene erroScene;
    private static Scene vazioScene;
    private static Scene sucessoScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("TELA INICIAL");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin);

        Parent fxmlHome = FXMLLoader.load(getClass().getResource("home.fxml"));
        homeScene = new Scene(fxmlHome);

        Parent fxmlErro = FXMLLoader.load(getClass().getResource("erro.fxml"));
        erroScene = new Scene(fxmlErro);

        Parent fxmlPreencher = FXMLLoader.load(getClass().getResource("preencher.fxml"));
        vazioScene = new Scene(fxmlPreencher);

        Parent fxmlSucesso = FXMLLoader.load(getClass().getResource("sucesso.fxml"));
        sucessoScene = new Scene(fxmlSucesso);
        fxmlSucesso.setOnMouseClicked(event -> {System.out.println("a");});

        primaryStage.setScene(loginScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScreen(String tela){
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
            case "vazio":
                stage.setScene(vazioScene);
                stage.setTitle("PREENCHA");
                break;
            case "sucesso":
                stage.setScene(sucessoScene);
                stage.setTitle("CADASTRADO");
                break;
        }
    }

}

