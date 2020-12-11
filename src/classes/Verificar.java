package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Verificar {

    public boolean Verificar(Usuario usuario) throws ClassNotFoundException {


        FileInputStream file = null;
        try {
            file = new FileInputStream("contas/" + usuario.getLogin() + ".acc");
            return false;
        } catch (FileNotFoundException e) {
            return true;
        }

    }
}
