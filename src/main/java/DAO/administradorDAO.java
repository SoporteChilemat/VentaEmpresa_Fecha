package DAO;

import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class administradorDAO {

    public static String contraseñaAdministrador() throws IOException, SQLException {
        String contraseña = "";
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT administrador FROM dbo.administrador");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                contraseña = res.getString("administrador");
            }
            estatuto.close();
        }
        return contraseña;
    }
}
