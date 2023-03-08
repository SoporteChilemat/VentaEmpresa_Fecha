/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.PorcentajeProveedorRebate;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class porcentajeProveedorRebateDAO {

    public static boolean registraPorcentajeProveedorRebate(PorcentajeProveedorRebate porcentajeProveedorRebate) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.porcentajeRebate (rut, año, porcentaje) VALUES ('"
                    + porcentajeProveedorRebate.getRut() + "', '"
                    + porcentajeProveedorRebate.getAño() + "', '"
                    + porcentajeProveedorRebate.getPorcentaje() + "')");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<PorcentajeProveedorRebate> selectPorcentajeXProveedorRebate(String rut) throws IOException, SQLException {
        ArrayList<PorcentajeProveedorRebate> arrPorcentajeProveedorRebate = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.porcentajeRebate WHERE rut = '" + rut.replace(".", "") + "'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                PorcentajeProveedorRebate porcentajeProveedorRebate = new PorcentajeProveedorRebate();
                porcentajeProveedorRebate.setRut(res.getString("rut"));
                porcentajeProveedorRebate.setAño(res.getString("año"));
                porcentajeProveedorRebate.setPorcentaje(res.getString("porcentaje"));
                arrPorcentajeProveedorRebate.add(porcentajeProveedorRebate);
            }
            res.close();
            estatuto.close();
        }
        return arrPorcentajeProveedorRebate;
    }

    public static ArrayList<PorcentajeProveedorRebate> selectPorcentajeXProveedorRebateLike(String rut) throws IOException, SQLException {
        System.out.println("SELECT * FROM dbo.porcentajeRebate WHERE rut LIKE '%" + rut + "%'");
        ArrayList<PorcentajeProveedorRebate> arrPorcentajeProveedorRebate = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.porcentajeRebate WHERE rut LIKE '%" + rut.replace(".", "") + "%'");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                PorcentajeProveedorRebate porcentajeProveedorRebate = new PorcentajeProveedorRebate();
                porcentajeProveedorRebate.setRut(res.getString("rut"));
                porcentajeProveedorRebate.setAño(res.getString("año"));
                porcentajeProveedorRebate.setPorcentaje(res.getString("porcentaje"));
                arrPorcentajeProveedorRebate.add(porcentajeProveedorRebate);
            }
            res.close();
            estatuto.close();
        }
        return arrPorcentajeProveedorRebate;
    }

    public static boolean eliminaPorcentajeProveedorRebate(String rut, String año) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.execute("DELETE from dbo.porcentajeRebate WHERE rut = '" + rut.replace(".", "") + "' AND año = '" + año + "'");
            estatuto.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
