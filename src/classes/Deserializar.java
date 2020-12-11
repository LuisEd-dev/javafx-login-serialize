package classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializar {
    public ArrayList<Usuario> Deserializar() throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream("contas/contas.acc");

        ObjectInputStream object = new ObjectInputStream(file);
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) object.readObject();
        object.close();
        return usuarios;

    }

    public Usuario Buscar(String usuario) throws IOException, ClassNotFoundException {

        try{
            for(Usuario conta : new Deserializar().Deserializar() ){
                if(conta.getLogin().equals(usuario)){
                    return conta;
                }
            }
        } catch (Exception EOFException) {

        }
        return null;
    }
}
