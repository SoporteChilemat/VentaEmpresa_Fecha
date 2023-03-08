/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.OrdenCompra;
import static Principal.Principal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sopor
 */
public class ordenCompraDAO {

    public static boolean insertOrdenCompra(OrdenCompra ordenCompra) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.execute("INSERT INTO dbo.ordenCompra (numeroOC, proveedor, fecha) VALUES ('"
                    + ordenCompra.getNumeroOC() + "','"
                    + ordenCompra.getProveedor() + "','"
                    + ordenCompra.getFecha() + "')");
            estatuto.close();

            return true;
        } catch (Exception ex) {
            System.out.println("insertFactura ex " + ex);
            return false;
        }
    }

    public static OrdenCompra selectOrdenCompra(String numeroOC) throws IOException, SQLException {
        System.out.println("SELECT * FROM dbo.ordenCompra WHERE numeroOC = '" + numeroOC + "'");
        try ( PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM dbo.ordenCompra WHERE numeroOC = '" + numeroOC + "'");  ResultSet res = consulta.executeQuery()) {
            if (res.next()) {
                System.out.println("IN");
                OrdenCompra ordenCompra = new OrdenCompra();
                ordenCompra.setNumeroOC(res.getString("numeroOC"));
                ordenCompra.setProveedor(res.getString("proveedor"));
                ordenCompra.setFecha(res.getString("fecha"));

                res.close();
                consulta.close();

                return ordenCompra;
            } else {
                return null;
            }
        }
    }

    public static void eliminarOC(String numeroOC) throws IOException, SQLException {
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeQuery("DELETE FROM dbo.ordenCompra WHERE numeroOC = '" + numeroOC + "'");
            estatuto.close();
        } catch (SQLException s) {
            System.out.println(s);
        }
    }
}
