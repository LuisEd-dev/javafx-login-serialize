package classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    private String hash;

    public MD5(String senha) throws NoSuchAlgorithmException {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(),0,senha.length());
        this.hash = new BigInteger(1,m.digest()).toString(16);
    }

    public String getHash() {
        return this.hash;
    }
}
