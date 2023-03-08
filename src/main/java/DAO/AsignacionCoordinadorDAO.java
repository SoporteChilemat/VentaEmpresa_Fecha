/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.AsignacionCoordinador;
import static Principal.Principal.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class AsignacionCoordinadorDAO {

    public static ArrayList<AsignacionCoordinador> selectAsignacionCoordinador() throws SQLException {
        ArrayList<AsignacionCoordinador> arrAsignacion = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.asignacionCoordinador");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                AsignacionCoordinador asignacionCoordinar = new AsignacionCoordinador();
                asignacionCoordinar.setCoordinador(res.getString("coordinador"));
                asignacionCoordinar.setVendedor(res.getString("vendedor"));
                arrAsignacion.add(asignacionCoordinar);
            }
            res.close();
            estatuto.close();
        }
        return arrAsignacion;
    }

    public static boolean registraCoordinadorVendedor(String vendedor, String coordinador) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.asignacionCoordinador (coordinador, vendedor) VALUES ('"
                    + coordinador + "', '"
                    + vendedor + "')");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean eliminaCoordinadorVendedor(String vendedor) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.asignacionCoordinador WHERE vendedor = '" + vendedor + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean actualizaCoordinadorVendedor(String vendedor, String coordinador) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.asignacionCoordinador SET coordinador ='" + coordinador + "' WHERE vendedor = '" + vendedor + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
