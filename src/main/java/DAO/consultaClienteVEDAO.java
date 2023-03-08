package DAO;

import Clases.ClienteVE;
import static Principal.Principal.conex2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class consultaClienteVEDAO {

    public static boolean registraClientes(String rut, String razonSocial, String nombre) {

        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.clientes (rut, razonSocial,nombreVendedor) VALUES ('"
                    + rut + "', '"
                    + razonSocial + "', '"
                    + nombre + "')");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<ClienteVE> consultaClientesVE() {

        ArrayList<ClienteVE> arrClientes = new ArrayList<>();
        try ( PreparedStatement consulta = conex2.getConnection().prepareStatement("SELECT rut, razonSocial, nombreVendedor from dbo.clientes");  ResultSet res = consulta.executeQuery()) {
            while (res.next()) {
                ClienteVE cliente = new ClienteVE();
                cliente.setRut(res.getString("rut"));
                cliente.setRazonSocial(res.getString("razonSocial"));
                cliente.setNombreVendedor(res.getString("nombreVendedor"));
                arrClientes.add(cliente);
            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arrClientes;
    }

    public static boolean eliminaCliente(String rut) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.clientes WHERE rut = '" + rut + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void actualizaClienteVendedor(String rut, String razonSocial, String nombreVendedor, String nombreVendedorNuevo) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.maestra SET peso ='" + nombreVendedorNuevo + "' WHERE rut = '" + rut + "' AND razonSocial = '" + razonSocial + "' AND nombreVendedor = '" + nombreVendedor + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean eliminaClientesVE(String nombreVendedor) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.clientes WHERE nombreVendedor = '" + nombreVendedor + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
