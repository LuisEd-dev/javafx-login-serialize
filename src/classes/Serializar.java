package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializar {

    public Serializar(Usuario usuario) throws IOException {

        FileOutputStream file = new FileOutputStream("contas/" + usuario.getLogin() + ".acc");
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(usuario);

        object.close();

    }
}