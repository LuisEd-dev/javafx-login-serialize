package classes;

import java.io.*;
import java.util.ArrayList;

public class Serializar {

    public Serializar(Usuario usuario) throws IOException {

        try{

            FileInputStream file = new FileInputStream("contas/contas.acc");

            ObjectInputStream object = new ObjectInputStream(file);
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) object.readObject();
            object.close();

            usuarios.add(usuario);

            FileOutputStream file2 = new FileOutputStream("contas/contas.acc");
            ObjectOutputStream object2 = new ObjectOutputStream(file2);
            object2.writeObject(usuarios);
            object2.close();
        } catch (Exception EOFException){

            ArrayList lista = new ArrayList();
            lista.add(usuario);

            File criar = new File("contas/contas.acc");
            criar.createNewFile();

            FileOutputStream file = new FileOutputStream("contas/contas.acc", false);
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(lista);
            object.close();
        }

    }

}