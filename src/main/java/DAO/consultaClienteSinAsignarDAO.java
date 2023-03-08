/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Clases.ClienteVESinAsignar;
import static Principal.Principal.conex2;

/**
 *
 * @author sopor
 */
public class consultaClienteSinAsignarDAO {

    public static boolean registraClientesSinAsignar(ClienteVESinAsignar clienteVESinAsignar) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.clientesSinAsignar (rut, razonSocial) VALUES ('"
                    + clienteVESinAsignar.getRut() + "', '"
                    + clienteVESinAsignar.getRazonSocial() + "')");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<ClienteVESinAsignar> consultaClientesVESinAsignar() {
        ArrayList<ClienteVESinAsignar> arrClientesSinAsignar = new ArrayList<>();
        try ( PreparedStatement consulta = conex2.getConnection().prepareStatement("SELECT rut, razonSocial from dbo.clientesSinAsignar");  ResultSet res = consulta.executeQuery()) {
            while (res.next()) {
                ClienteVESinAsignar cliente = new ClienteVESinAsignar();
                cliente.setRut(res.getString("rut"));
                cliente.setRazonSocial(res.getString("razonSocial"));
                arrClientesSinAsignar.add(cliente);
            }
            res.close();
            consulta.close();
        } catch (SQLException e) {
        }
        return arrClientesSinAsignar;
    }

    public static boolean eliminaClienteSinAsignar(String rut) {
        try ( Statement estatuto = conex2.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.clientesSinAsignar WHERE rut = '" + rut + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
