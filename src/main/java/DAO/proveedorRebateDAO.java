/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.ProveedorRebate;
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
public class proveedorRebateDAO {

    public static int registraProveedorRebate(ProveedorRebate proveedorRebate) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.rebateProveedor (nombre, rut) VALUES ('"
                    + proveedorRebate.getNombre() + "', '"
                    + proveedorRebate.getRut() + "')");
            estatuto.close();
            return 0;
        } catch (SQLException e) {
            if (e.toString().contains("PRIMARY KEY")) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static ArrayList<ProveedorRebate> selectProveedorRebate() throws IOException, SQLException {
        ArrayList<ProveedorRebate> arrRebateProveedor = new ArrayList<>();
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.rebateProveedor");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                ProveedorRebate proveedorRebate = new ProveedorRebate();
                proveedorRebate.setNombre(res.getString("nombre"));
                proveedorRebate.setRut(res.getString("rut"));
                arrRebateProveedor.add(proveedorRebate);
            }
            res.close();
            estatuto.close();
        }
        return arrRebateProveedor;
    }
}
