/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static Principal.Principal.conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ActualizaCodigoPrecioDAO {

    public static void actualizar(String precio, String codigo, String desde, String hasta) throws SQLException {
        String query = "UPDATE [ventaempresa].[dbo].[producto] \nSET [ventaempresa].[dbo].[producto].costoUnitario = ? \nFROM [ventaempresa].[dbo].[producto] as a \nINNER JOIN [dbo].[factura] as b ON a.folio = b.folio \nWHERE b.vendedor = ? AND a.codigo = ? and CONVERT(date, b.fechaEmision, 23) BETWEEN '" + desde + "' AND '" + hasta + "'";
        PreparedStatement stmt = conex.getConnection().prepareStatement(query);
        stmt.setString(1, precio);
        stmt.setString(2, "PATRICIO ROMAN");
        stmt.setString(3, codigo);
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " rows updated.");
        stmt.close();
    }
}
