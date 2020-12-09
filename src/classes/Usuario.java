package classes;

import java.io.*;
import java.security.NoSuchAlgorithmException;


public class Usuario implements Serializable {
    private String login;
    private String senha;

    public Usuario(String login, String senha, boolean crip, String opcao) throws NoSuchAlgorithmException {
        this.login = login;
        this.senha = senha;

        if(opcao == "cadastrar"){
            if(crip){
                this.senha =  new MD5(senha).getHash();
            }
        } else if (opcao == "logar"){

        } else {
            System.out.println("Opção Invalida!");
        }
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }
}
