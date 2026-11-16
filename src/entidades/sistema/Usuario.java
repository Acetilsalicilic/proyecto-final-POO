package entidades.sistema;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Objects;

public class Usuario {
    private String nombreUsuario;
    private String passwd;

    public Usuario(String nombreUsuario, String passwd) {
        this.nombreUsuario = nombreUsuario;
        this.passwd = hash(passwd);
    }

    public String hash(String s) {
        try {
            var md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(s.getBytes());
            return HexFormat.of().formatHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Couldn't find SHA-256 algorithm");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(passwd, usuario.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario, passwd);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
