package DAO;

import Clases.ClienteVE;
import static Principal.Principal.conex2;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clientesDAO {

    public static String vendedorCliente(String rut) throws IOException, SQLException {
        String vendedor = "";
        try ( PreparedStatement estatuto = conex2.getConnection().prepareStatement("SELECT nombreVendedor FROM dbo.clientes WHERE rut = '" + rut + "'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                vendedor = res.getString("nombreVendedor");
            }
            res.close();
            estatuto.close();
        }
        return vendedor;
    }

    public static ArrayList<String> selectDistinctNombre() throws IOException, SQLException {
        ArrayList<String> arrNombres = new ArrayList<>();
        try ( PreparedStatement estatuto = conex2.getConnection().prepareStatement("SELECT DISTINCT nombreVendedor FROM dbo.clientes");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                arrNombres.add(res.getString("nombreVendedor"));
            }
            res.close();
            estatuto.close();
        }
        return arrNombres;
    }

    public static ArrayList<ClienteVE> selectXNombre(String nombre) throws IOException, SQLException {
        ArrayList<ClienteVE> arrCliente = new ArrayList<>();
        try ( PreparedStatement estatuto = conex2.getConnection().prepareStatement("SELECT rut, razonSocial FROM  dbo.clientes WHERE nombreVendedor = '" + nombre + "'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                ClienteVE cliente = new ClienteVE();
                cliente.setNombreVendedor(nombre);
                cliente.setRut(res.getString("rut"));
                cliente.setRazonSocial(res.getString("razonSocial"));
                arrCliente.add(cliente);
            }
            res.close();
            estatuto.close();
        }
        return arrCliente;
    }
}
