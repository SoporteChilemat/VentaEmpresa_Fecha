package DAO;

import static Principal.Principal.conex2;
import Clases.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class consultaVendedorVEDAO {

    public static boolean registraVendedor(String nombre) {

        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.vendedores (nombre) VALUES ('" + nombre + "')");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Vendedor> consultaVendedoresVE() {
        ArrayList<Vendedor> arrVE = new ArrayList<>();
        try ( PreparedStatement estatuto = conex2.getConnection().prepareStatement("SELECT * from dbo.vendedores");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Vendedor ve = new Vendedor();
                ve.setNombre(res.getString("nombre"));
                arrVE.add(ve);
            }
            res.close();
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arrVE;
    }

    public static boolean eliminaVendedorVE(String nombre) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.vendedores WHERE nombre = '" + nombre + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
