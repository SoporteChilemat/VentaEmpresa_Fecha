package DAO;

import Clases.Usuario;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class usuariosDAO {

    public static boolean insertUsuario(Usuario usuario) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO dbo.usuarios (nombre, contraseña, tipo) VALUES ('"
                    + usuario.getNombre() + "','"
                    + usuario.getContraseña() + "','"
                    + usuario.getTipo() + "')");
            estatuto.close();

            return true;
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            return false;
        }
    }

    public static Usuario selectUsuario(String nombre, String contraseña) throws IOException, SQLException {
        Usuario usuario = new Usuario();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT nombre, contraseña, tipo FROM dbo.usuarios WHERE nombre = '" + nombre + "' AND contraseña = '" + contraseña + "'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                usuario.setNombre(res.getString("nombre"));
                usuario.setContraseña(res.getString("contraseña"));
                usuario.setTipo(res.getInt("tipo"));
            }
            estatuto.close();
        }
        return usuario;
    }
}
