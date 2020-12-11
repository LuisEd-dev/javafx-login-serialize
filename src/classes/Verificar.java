package classes;

public class Verificar {

    public boolean Verificar(Usuario usuario) {
        try{
            for(Usuario conta : new Deserializar().Deserializar()){
                if(conta.getLogin().equals(usuario.getLogin())){
                    return false;
                }
            }
        } catch (Exception e){
            return true;
        }
        return true;
    }
}
